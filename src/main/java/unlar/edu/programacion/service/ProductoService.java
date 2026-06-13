package unlar.edu.programacion.service;

import java.util.List;

import unlar.edu.programacion.dto.ProductoRequest;
import unlar.edu.programacion.dto.ProductoResponse;

/**
 * Servicio para la gestión de productos.
 *
 * @author Grupo
 * @since 1.0
 */
public interface ProductoService {

    List<ProductoResponse> findAll();

    ProductoResponse findById(Long id);

    ProductoResponse create(ProductoRequest request);

    ProductoResponse update(Long id, ProductoRequest request);

    void deleteById(Long id);

    List<ProductoResponse> findByCategoria(Long categoriaId);

    List<ProductoResponse> buscarPorNombre(String texto);

}