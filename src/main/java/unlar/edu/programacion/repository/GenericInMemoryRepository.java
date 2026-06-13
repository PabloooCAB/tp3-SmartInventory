package unlar.edu.programacion.repository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import unlar.edu.programacion.exception.ResourceNotFoundException;

/**
 * Implementación genérica en memoria para operaciones CRUD.
 *
 * @param <T> tipo de entidad
 * @param <ID> tipo de identificador
 *
 * @author Grupo
 * @since 1.0
 */
public abstract class GenericInMemoryRepository<T, ID>
        implements IGenericRepository<T, ID> {

    protected final ConcurrentHashMap<ID, T> dataStore = new ConcurrentHashMap<>();
    protected final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public List<T> findAll() {
        return new ArrayList<>(dataStore.values());
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(dataStore.get(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public T save(T entity) {

        try {

            Method getId = entity.getClass().getMethod("getId");
            ID id = (ID) getId.invoke(entity);

            if (id == null) {

                Long nuevoId = idGenerator.incrementAndGet();

                Method setId = entity.getClass()
                        .getMethod("setId", Long.class);

                setId.invoke(entity, nuevoId);

                id = (ID) nuevoId;
            }

            dataStore.put(id, entity);

            return entity;

        } catch (Exception e) {
            throw new RuntimeException("Error al guardar entidad", e);
        }
    }

    @Override
    public void deleteById(ID id) {

        if (!dataStore.containsKey(id)) {
            throw new ResourceNotFoundException(
                    "No existe un registro con id: " + id
            );
        }

        dataStore.remove(id);
    }

    @Override
    public boolean existsById(ID id) {
        return dataStore.containsKey(id);
    }

    @Override
    public long count() {
        return dataStore.size();
    }
}