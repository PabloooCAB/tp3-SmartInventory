package unlar.edu.programacion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import unlar.edu.programacion.dto.CategoriaRequest;
import unlar.edu.programacion.dto.CategoriaResponse;
import unlar.edu.programacion.service.CategoriaService;

/**
 * Controlador para la gestión de categorías.
 *
 * @author Grupo
 * @since 1.0
 */
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                categoriaService.findById(id)
        );
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> create(
            @Valid @RequestBody CategoriaRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoriaRequest request) {

        return ResponseEntity.ok(
                categoriaService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {

        categoriaService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}