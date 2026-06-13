package unlar.edu.programacion.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuración de umbrales de stock.
 *
 * @author Grupo
 * @since 1.0
 */
@ConfigurationProperties(prefix = "inventario.stock")
public record StockConfig(
        int minimo,
        int critico
) {
}