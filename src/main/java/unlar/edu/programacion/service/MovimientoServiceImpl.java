package unlar.edu.programacion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import unlar.edu.programacion.dto.MovimientoRequest;
import unlar.edu.programacion.dto.MovimientoResponse;
import unlar.edu.programacion.exception.InsufficientStockException;
import unlar.edu.programacion.exception.ResourceNotFoundException;
import unlar.edu.programacion.model.MovimientoInventario;
import unlar.edu.programacion.model.Producto;
import unlar.edu.programacion.model.TipoMovimiento;
import unlar.edu.programacion.repository.MovimientoRepository;
import unlar.edu.programacion.repository.ProductoRepository;

/**
 * Implementación del servicio de movimientos.
 *
 * @author Grupo
 * @since 1.0
 */
@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final ProductoRepository productoRepository;

    public MovimientoServiceImpl(
            MovimientoRepository movimientoRepository,
            ProductoRepository productoRepository) {

        this.movimientoRepository = movimientoRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public MovimientoResponse registrarMovimiento(MovimientoRequest request) {

        Producto producto = productoRepository.findById(request.productoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Producto no encontrado con id: "
                                        + request.productoId()));

        int stockResultante;

        if (request.tipo() == TipoMovimiento.ENTRADA) {

            stockResultante =
                    producto.incrementarStock(request.cantidad());

        } else {

            if (producto.getStock().get() < request.cantidad()) {
                throw new InsufficientStockException(
                        "Stock insuficiente"
                );
            }

            stockResultante =
                    producto.decrementarStock(request.cantidad());
        }

        productoRepository.save(producto);

        MovimientoInventario movimiento =
                new MovimientoInventario(
                        null,
                        producto.getId(),
                        request.tipo(),
                        request.cantidad(),
                        stockResultante,
                        request.motivo(),
                        LocalDateTime.now()
                );

        movimiento = movimientoRepository.save(movimiento);

        return toResponse(movimiento);
    }

    @Override
    public List<MovimientoResponse> findByProductoId(Long productoId) {

        return movimientoRepository.findByProductoId(productoId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private MovimientoResponse toResponse(
            MovimientoInventario movimiento) {

        return new MovimientoResponse(
                movimiento.getId(),
                movimiento.getProductoId(),
                movimiento.getTipo(),
                movimiento.getCantidad(),
                movimiento.getStockResultante(),
                movimiento.getMotivo(),
                movimiento.getFecha()
        );
    }
}