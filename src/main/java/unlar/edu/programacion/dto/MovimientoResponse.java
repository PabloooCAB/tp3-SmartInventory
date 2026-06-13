package unlar.edu.programacion.dto;

import java.time.LocalDateTime;
import unlar.edu.programacion.model.TipoMovimiento;

/**
 * DTO de respuesta para movimientos de inventario.
 *
 * @author Grupo
 * @since 1.0
 */
public record MovimientoResponse(

        Long id,
        Long productoId,
        TipoMovimiento tipo,
        int cantidad,
        int stockResultante,
        String motivo,
        LocalDateTime fecha

) {
}