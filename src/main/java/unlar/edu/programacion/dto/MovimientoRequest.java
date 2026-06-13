package unlar.edu.programacion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import unlar.edu.programacion.model.TipoMovimiento;

/**
 * DTO para registrar movimientos de inventario.
 *
 * @author Grupo
 * @since 1.0
 */
public record MovimientoRequest(

        @NotNull(message = "El producto es obligatorio")
        Long productoId,

        @NotNull(message = "El tipo de movimiento es obligatorio")
        TipoMovimiento tipo,

        @Positive(message = "La cantidad debe ser mayor a 0")
        int cantidad,

        @NotBlank(message = "El motivo es obligatorio")
        String motivo

) {
}