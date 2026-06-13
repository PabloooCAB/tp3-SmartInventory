package unlar.edu.programacion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para la creación y actualización de categorías.
 *
 * @author Grupo
 * @since 1.0
 */
public record CategoriaRequest(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String nombre

) {
}