package unlar.edu.programacion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unlar.edu.programacion.dto.AlertaStockResponse;
import unlar.edu.programacion.service.AlertaService;

/**
 * Controlador para la gestión de alertas de stock.
 *
 * @author Grupo
 * @since 1.0
 */
@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @GetMapping("/stock-bajo")
    public ResponseEntity<List<AlertaStockResponse>> obtenerAlertas() {

        return ResponseEntity.ok(
                alertaService.obtenerProductosConStockBajo()
        );
    }
}