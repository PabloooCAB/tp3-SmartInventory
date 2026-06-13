package unlar.edu.programacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import unlar.edu.programacion.dto.AlertaStockResponse;
import unlar.edu.programacion.model.NivelAlerta;
import unlar.edu.programacion.model.Producto;
import unlar.edu.programacion.repository.ProductoRepository;

/**
 * Implementación del servicio de alertas.
 *
 * @author Grupo
 * @since 1.0
 */
@Service
public class AlertaServiceImpl implements AlertaService {

    private static final int STOCK_MINIMO = 10;
    private static final int STOCK_CRITICO = 3;

    private final ProductoRepository productoRepository;

    public AlertaServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public NivelAlerta calcularNivel(int stock) {

        if (stock < STOCK_CRITICO) {
            return NivelAlerta.CRITICO;
        }

        if (stock < STOCK_MINIMO) {
            return NivelAlerta.BAJO;
        }

        return NivelAlerta.NORMAL;
    }

    @Override
    public List<AlertaStockResponse> obtenerProductosConStockBajo() {

        return productoRepository.findAll()
                .stream()
                .filter(producto ->
                        calcularNivel(producto.getStock().get())
                                != NivelAlerta.NORMAL)
                .map(this::toResponse)
                .toList();
    }

    private AlertaStockResponse toResponse(Producto producto) {

        return new AlertaStockResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getStock().get(),
                calcularNivel(producto.getStock().get())
        );
    }
}