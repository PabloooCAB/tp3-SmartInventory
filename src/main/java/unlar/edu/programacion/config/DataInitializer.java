package unlar.edu.programacion.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import unlar.edu.programacion.model.Categoria;
import unlar.edu.programacion.repository.CategoriaRepository;

/**
 * Inicialización de datos de prueba.
 *
 * @author Grupo
 * @since 1.0
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;

    public DataInitializer(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {

        Categoria electronicos = new Categoria();
        electronicos.setNombre("Electrónicos");
        categoriaRepository.save(electronicos);

        Categoria alimentos = new Categoria();
        alimentos.setNombre("Alimentos");
        categoriaRepository.save(alimentos);

        Categoria limpieza = new Categoria();
        limpieza.setNombre("Limpieza");
        categoriaRepository.save(limpieza);

        System.out.println("Smart Inventory iniciado correctamente.");
    }
}