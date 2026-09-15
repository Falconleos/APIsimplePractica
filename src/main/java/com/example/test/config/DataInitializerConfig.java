package com.example.test.config;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializerConfig {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("123456"));
                user.setRole("ADMIN"); // O el campo que uses para roles/perfiles
                userRepository.save(user);
                System.out.println("Usuario administrador de prueba creado con éxito.");
            }
        };
    }
}