package unlar.edu.programacion.service;

import java.util.Map;

/**
 * Servicio para generar reportes de rendimiento.
 *
 * @author Grupo
 * @since 1.0
 */
public interface PerformanceReportService {

    Map<String, Object> generarReporte();

}