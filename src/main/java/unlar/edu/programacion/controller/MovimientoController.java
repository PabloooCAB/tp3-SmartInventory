package unlar.edu.programacion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import unlar.edu.programacion.dto.MovimientoRequest;
import unlar.edu.programacion.dto.MovimientoResponse;
import unlar.edu.programacion.service.MovimientoService;

/**
 * Controlador para la gestión de movimientos de inventario.
 *
 * @author Grupo
 * @since 1.0
 */
@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @PostMapping
    public ResponseEntity<MovimientoResponse> registrarMovimiento(
            @Valid @RequestBody MovimientoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movimientoService.registrarMovimiento(request));
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<List<MovimientoResponse>> findByProductoId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                movimientoService.findByProductoId(id)
        );
    }
}