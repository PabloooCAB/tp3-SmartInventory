package unlar.edu.programacion.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unlar.edu.programacion.service.PerformanceReportService;

/**
 * Controlador para reportes de rendimiento.
 *
 * @author Grupo
 * @since 1.0
 */
@RestController
@RequestMapping("/api/admin")
public class PerformanceReportController {

    private final PerformanceReportService performanceReportService;

    public PerformanceReportController(
            PerformanceReportService performanceReportService) {
        this.performanceReportService = performanceReportService;
    }

    @GetMapping("/performance-report")
    public ResponseEntity<Map<String, Object>> generarReporte() {
        return ResponseEntity.ok(
                performanceReportService.generarReporte()
        );
    }
}