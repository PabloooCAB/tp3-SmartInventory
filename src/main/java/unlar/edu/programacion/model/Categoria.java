package unlar.edu.programacion.model;

/**
 * Representa una categoría de productos.
 *
 * @author Grupo
 * @since 1.0
 */
public class Categoria {

    private Long id;
    private String nombre;

    public Categoria() {
    }

    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la categoría.
     *
     * @return id de la categoría
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la categoría.
     *
     * @param id identificador a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return nombre de la categoría
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombre nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}