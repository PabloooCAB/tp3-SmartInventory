package unlar.edu.programacion.exception;

/**
 * Excepción lanzada cuando se intenta retirar más stock del disponible.
 *
 * @author Grupo
 * @since 1.0
 */
public class InsufficientStockException extends RuntimeException {

    public InsufficientStockException(String mensaje) {
        super(mensaje);
    }

}