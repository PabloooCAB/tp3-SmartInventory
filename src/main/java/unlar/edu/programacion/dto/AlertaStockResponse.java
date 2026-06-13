package unlar.edu.programacion.dto;

import unlar.edu.programacion.model.NivelAlerta;

/**
 * DTO de respuesta para alertas de stock.
 *
 * @author Grupo
 * @since 1.0
 */
public record AlertaStockResponse(

        Long productoId,
        String nombreProducto,
        int stock,
        NivelAlerta nivelAlerta

) {
}