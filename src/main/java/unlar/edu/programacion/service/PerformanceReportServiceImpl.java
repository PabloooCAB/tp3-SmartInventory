package unlar.edu.programacion.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import unlar.edu.programacion.repository.ProductoRepository;

/**
 * Implementación del reporte de performance.
 *
 * @author Grupo
 * @since 1.0
 */
@Service
public class PerformanceReportServiceImpl
        implements PerformanceReportService {

    private final ProductoRepository productoRepository;

    public PerformanceReportServiceImpl(
            ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }

    @Override
    public Map<String, Object> generarReporte() {

        Map<String, Object> reporte = new HashMap<>();

        long inicio = System.nanoTime();

        productoRepository.findAll();

        long fin = System.nanoTime();

        reporte.put("findAll", (fin - inicio) + " ns");
        reporte.put("complejidad", "O(n)");

        return reporte;
    }
}