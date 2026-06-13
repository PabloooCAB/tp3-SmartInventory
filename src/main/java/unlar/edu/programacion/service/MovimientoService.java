package unlar.edu.programacion.service;

import java.util.List;

import unlar.edu.programacion.dto.MovimientoRequest;
import unlar.edu.programacion.dto.MovimientoResponse;

/**
 * Servicio para la gestión de movimientos de inventario.
 *
 * @author Grupo
 * @since 1.0
 */
public interface MovimientoService {

    MovimientoResponse registrarMovimiento(MovimientoRequest request);

    List<MovimientoResponse> findByProductoId(Long productoId);

}