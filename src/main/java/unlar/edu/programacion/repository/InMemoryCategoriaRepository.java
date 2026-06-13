package unlar.edu.programacion.repository;

import org.springframework.stereotype.Repository;

import unlar.edu.programacion.model.Categoria;

/**
 * Implementación en memoria del repositorio de categorías.
 *
 * @author Grupo
 * @since 1.0
 */
@Repository
public class InMemoryCategoriaRepository
        extends GenericInMemoryRepository<Categoria, Long>
        implements CategoriaRepository {

}