package unlar.edu.programacion.service;

import java.util.List;

import unlar.edu.programacion.dto.CategoriaRequest;
import unlar.edu.programacion.dto.CategoriaResponse;

/**
 * Servicio para la gestión de categorías.
 *
 * @author Grupo
 * @since 1.0
 */
public interface CategoriaService {

    List<CategoriaResponse> findAll();

    CategoriaResponse findById(Long id);

    CategoriaResponse create(CategoriaRequest request);

    CategoriaResponse update(Long id, CategoriaRequest request);

    void deleteById(Long id);

}