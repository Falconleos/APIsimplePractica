package com.example.test.config;

import com.example.test.model.Product; // Ajusta el import según tu entidad
import com.example.test.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductDataInitializer {

    @Bean
    public CommandLineRunner initProducts(ProductRepository productRepository) {
        return args -> {
            // Solo inserta datos si la tabla está vacía para evitar duplicados
            if (productRepository.count() == 0) {
                // Nota: Ajusta los atributos (nombre, precio, etc.) según los campos de tu entidad Product
                Product p1 = new Product();
                p1.setName("Laptop Gamer");
                p1.setPrice(1200.00);
                // p1.setDescription("Laptop de alto rendimiento");

                Product p2 = new Product();
                p2.setName("Teclado Mecánico RGB");
                p2.setPrice(75.50);
                // p2.setDescription("Teclado mecánico switches red");

                productRepository.save(p1);
                productRepository.save(p2);

                System.out.println(">> Productos iniciales insertados en la base de datos.");
            }
        };
    }
}