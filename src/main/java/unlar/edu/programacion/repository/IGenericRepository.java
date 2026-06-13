package unlar.edu.programacion.repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio genérico para operaciones CRUD.
 *
 * @param <T> tipo de entidad
 * @param <ID> tipo de identificador
 *
 * @author Grupo
 * @since 1.0
 */
public interface IGenericRepository<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T entity);

    void deleteById(ID id);

    boolean existsById(ID id);

    long count();
}