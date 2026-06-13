package unlar.edu.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import unlar.edu.programacion.model.MovimientoInventario;

/**
 * Implementación en memoria del repositorio de movimientos.
 *
 * @author Grupo
 * @since 1.0
 */
@Repository
public class InMemoryMovimientoRepository
        extends GenericInMemoryRepository<MovimientoInventario, Long>
        implements MovimientoRepository {

    @Override
    public List<MovimientoInventario> findByProductoId(Long productoId) {

        return dataStore.values()
                .stream()
                .filter(movimiento ->
                        movimiento.getProductoId().equals(productoId))
                .toList();
    }
}