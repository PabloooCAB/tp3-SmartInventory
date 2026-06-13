package unlar.edu.programacion.repository;

import java.util.List;

import unlar.edu.programacion.model.Producto;

/**
 * Repositorio de productos.
 *
 * @author Grupo
 * @since 1.0
 */
public interface ProductoRepository
        extends IGenericRepository<Producto, Long> {

    List<Producto> findByCategoria(Long categoriaId);

    List<Producto> buscarPorNombre(String texto);

}