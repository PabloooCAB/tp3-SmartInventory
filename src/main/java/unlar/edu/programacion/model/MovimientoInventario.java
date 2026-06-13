package unlar.edu.programacion.model;

import java.time.LocalDateTime;

/**
 * Representa un movimiento de inventario.
 *
 * @author Grupo
 * @since 1.0
 */
public class MovimientoInventario {

    private Long id;
    private Long productoId;
    private TipoMovimiento tipo;
    private int cantidad;
    private int stockResultante;
    private String motivo;
    private LocalDateTime fecha;

    public MovimientoInventario() {
    }

    public MovimientoInventario(Long id, Long productoId, TipoMovimiento tipo,
                                int cantidad, int stockResultante,
                                String motivo, LocalDateTime fecha) {
        this.id = id;
        this.productoId = productoId;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.stockResultante = stockResultante;
        this.motivo = motivo;
        this.fecha = fecha;
    }

    /**
     * @return identificador del movimiento
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id identificador del movimiento
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return identificador del producto
     */
    public Long getProductoId() {
        return productoId;
    }

    /**
     * @param productoId identificador del producto
     */
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    /**
     * @return tipo de movimiento
     */
    public TipoMovimiento getTipo() {
        return tipo;
    }

    /**
     * @param tipo tipo de movimiento
     */
    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    /**
     * @return cantidad movida
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad cantidad movida
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return stock resultante
     */
    public int getStockResultante() {
        return stockResultante;
    }

    /**
     * @param stockResultante stock luego del movimiento
     */
    public void setStockResultante(int stockResultante) {
        this.stockResultante = stockResultante;
    }

    /**
     * @return motivo del movimiento
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo motivo del movimiento
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return fecha del movimiento
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * @param fecha fecha del movimiento
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}