package unlar.edu.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import unlar.edu.programacion.model.Producto;

/**
 * Implementación en memoria del repositorio de productos.
 *
 * @author Grupo
 * @since 1.0
 */
@Repository
public class InMemoryProductoRepository
        extends GenericInMemoryRepository<Producto, Long>
        implements ProductoRepository {

    @Override
    public List<Producto> findByCategoria(Long categoriaId) {

        return dataStore.values()
                .stream()
                .filter(producto ->
                        producto.getCategoria() != null
                                && producto.getCategoria().getId().equals(categoriaId))
                .toList();
    }

    @Override
    public List<Producto> buscarPorNombre(String texto) {

        String busqueda = texto.toLowerCase();

        return dataStore.values()
                .stream()
                .filter(producto ->
                        producto.getNombre().toLowerCase().contains(busqueda))
                .toList();
    }
}