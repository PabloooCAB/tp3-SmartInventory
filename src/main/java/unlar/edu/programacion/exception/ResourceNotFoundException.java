package unlar.edu.programacion.exception;

/**
 * Excepción lanzada cuando una entidad no existe.
 *
 * @author Grupo
 * @since 1.0
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }

}