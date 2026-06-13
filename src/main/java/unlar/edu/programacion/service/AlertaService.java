package unlar.edu.programacion.service;

import java.util.List;

import unlar.edu.programacion.dto.AlertaStockResponse;
import unlar.edu.programacion.model.NivelAlerta;

/**
 * Servicio para la gestión de alertas de stock.
 *
 * @author Grupo
 * @since 1.0
 */
public interface AlertaService {

    NivelAlerta calcularNivel(int stock);

    List<AlertaStockResponse> obtenerProductosConStockBajo();

}