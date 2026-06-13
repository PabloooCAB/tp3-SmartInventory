package unlar.edu.programacion.exception;

/**
 * Excepción lanzada cuando se viola una regla de negocio.
 *
 * @author Grupo
 * @since 1.0
 */
public class BusinessRuleException extends RuntimeException {

    public BusinessRuleException(String mensaje) {
        super(mensaje);
    }

}