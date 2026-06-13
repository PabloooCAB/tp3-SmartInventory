package unlar.edu.programacion.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representa un producto del inventario.
 *
 * @author Grupo
 * @since 1.0
 */
public class Producto {

    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private AtomicInteger stock;

    public Producto() {
        this.stock = new AtomicInteger(0);
    }

    public Producto(Long id, String nombre, String descripcion,
                    double precio, Categoria categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = new AtomicInteger(stock);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public AtomicInteger getStock() {
        return stock;
    }

    public void setStock(AtomicInteger stock) {
        this.stock = stock;
    }

    public int incrementarStock(int cantidad) {
        return stock.addAndGet(cantidad);
    }

    public int decrementarStock(int cantidad) {
        return stock.addAndGet(-cantidad);
    }
}