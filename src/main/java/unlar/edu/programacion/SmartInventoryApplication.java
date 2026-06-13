package unlar.edu.programacion;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import unlar.edu.programacion.config.StockConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableConfigurationProperties(StockConfig.class)

public class SmartInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SmartInventoryApplication.class,
                args
        );
    }
}