package unlar.edu.programacion.repository;

import java.util.List;

import unlar.edu.programacion.model.MovimientoInventario;

/**
 * Repositorio de movimientos de inventario.
 *
 * @author Grupo
 * @since 1.0
 */
public interface MovimientoRepository
        extends IGenericRepository<MovimientoInventario, Long> {

    List<MovimientoInventario> findByProductoId(Long productoId);

}