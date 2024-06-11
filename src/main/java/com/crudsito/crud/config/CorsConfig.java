package com.crudsito.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Esta clase proporciona configuración para permitir CORS en la aplicación Spring Boot.

@Configuration
public class CorsConfig {

    // Este método crea un bean de tipo WebMvcConfigurer para configurar CORS en la aplicación.
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            // Este método se llama para agregar la configuración de CORS al registro.
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                // Aquí se define la configuración CORS para todos los endpoints (/**).
                registry.addMapping("/**")

                        // Se permiten solicitudes desde el origen especificado (en este caso, el frontend local).
                        .allowedOrigins("http://localhost:8080") // Cambia esto al origen de tu frontend

                        // Se permiten los métodos HTTP especificados.
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")

                        // Se permiten todos los encabezados en las solicitudes.
                        .allowedHeaders("*")

                        // Se permiten las credenciales en las solicitudes (por ejemplo, cookies).
                        .allowCredentials(true);
            }
        };
    }
}
