package unlar.edu.programacion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import unlar.edu.programacion.dto.ProductoRequest;
import unlar.edu.programacion.dto.ProductoResponse;
import unlar.edu.programacion.service.ProductoService;

/**
 * Controlador para la gestión de productos.
 *
 * @author Grupo
 * @since 1.0
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                productoService.findById(id)
        );
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> create(
            @Valid @RequestBody ProductoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequest request) {

        return ResponseEntity.ok(
                productoService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {

        productoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProductoResponse>> buscarPorNombre(
            @RequestParam String q) {

        return ResponseEntity.ok(
                productoService.buscarPorNombre(q)
        );
    }
}