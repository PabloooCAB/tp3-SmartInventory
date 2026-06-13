package unlar.edu.programacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import unlar.edu.programacion.dto.CategoriaResponse;
import unlar.edu.programacion.dto.ProductoRequest;
import unlar.edu.programacion.dto.ProductoResponse;
import unlar.edu.programacion.exception.ResourceNotFoundException;
import unlar.edu.programacion.model.Categoria;
import unlar.edu.programacion.model.Producto;
import unlar.edu.programacion.repository.CategoriaRepository;
import unlar.edu.programacion.repository.ProductoRepository;

/**
 * Implementación del servicio de productos.
 *
 * @author Grupo
 * @since 1.0
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoServiceImpl(
            ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository) {

        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<ProductoResponse> findAll() {
        return productoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public ProductoResponse findById(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Producto no encontrado con id: " + id));

        return toResponse(producto);
    }

    @Override
    public ProductoResponse create(ProductoRequest request) {

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría no encontrada con id: "
                                        + request.categoriaId()));

        Producto producto = new Producto(
                null,
                request.nombre(),
                request.descripcion(),
                request.precio(),
                categoria,
                request.stockInicial()
        );

        return toResponse(productoRepository.save(producto));
    }

    @Override
    public ProductoResponse update(Long id, ProductoRequest request) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Producto no encontrado con id: " + id));

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría no encontrada con id: "
                                        + request.categoriaId()));

        producto.setNombre(request.nombre());
        producto.setDescripcion(request.descripcion());
        producto.setPrecio(request.precio());
        producto.setCategoria(categoria);

        productoRepository.save(producto);

        return toResponse(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoResponse> findByCategoria(Long categoriaId) {
        return productoRepository.findByCategoria(categoriaId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public List<ProductoResponse> buscarPorNombre(String texto) {
        return productoRepository.buscarPorNombre(texto)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private ProductoResponse toResponse(Producto producto) {

        CategoriaResponse categoriaResponse =
                new CategoriaResponse(
                        producto.getCategoria().getId(),
                        producto.getCategoria().getNombre()
                );

        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock().get(),
                categoriaResponse
        );
    }
}