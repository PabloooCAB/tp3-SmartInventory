package unlar.edu.programacion.dto;

/**
 * DTO de respuesta para productos.
 *
 * @author Grupo
 * @since 1.0
 */
public record ProductoResponse(

        Long id,
        String nombre,
        String descripcion,
        double precio,
        int stock,
        CategoriaResponse categoria

) {
}