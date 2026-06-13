package unlar.edu.programacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import unlar.edu.programacion.dto.CategoriaRequest;
import unlar.edu.programacion.dto.CategoriaResponse;
import unlar.edu.programacion.exception.BusinessRuleException;
import unlar.edu.programacion.exception.ResourceNotFoundException;
import unlar.edu.programacion.model.Categoria;
import unlar.edu.programacion.repository.CategoriaRepository;
import unlar.edu.programacion.repository.ProductoRepository;

/**
 * Implementación del servicio de categorías.
 *
 * @author Grupo
 * @since 1.0
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public CategoriaServiceImpl(
            CategoriaRepository categoriaRepository,
            ProductoRepository productoRepository) {

        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<CategoriaResponse> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public CategoriaResponse findById(Long id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría no encontrada con id: " + id));

        return toResponse(categoria);
    }

    @Override
    public CategoriaResponse create(CategoriaRequest request) {

        Categoria categoria = new Categoria();
        categoria.setNombre(request.nombre());

        return toResponse(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponse update(Long id, CategoriaRequest request) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría no encontrada con id: " + id));

        categoria.setNombre(request.nombre());

        categoriaRepository.save(categoria);

        return toResponse(categoria);
    }

    @Override
    public void deleteById(Long id) {

        categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría no encontrada con id: " + id));

        if (!productoRepository.findByCategoria(id).isEmpty()) {
            throw new BusinessRuleException(
                    "No se puede eliminar una categoría con productos asociados"
            );
        }

        categoriaRepository.deleteById(id);
    }

    private CategoriaResponse toResponse(Categoria categoria) {

        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNombre()
        );
    }
}