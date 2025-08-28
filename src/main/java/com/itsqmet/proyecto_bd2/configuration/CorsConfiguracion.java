package com.itsqmet.proyecto_bd2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfiguracion {


    //Marca ub metodo
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        //Instanciamos la clase
        CorsConfiguration configuration = new CorsConfiguration();
        //Se permite peticiones desde el origen de Angular
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        //Se permiten los metodos http
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        //Permite cualquier cabecera en la solicitud
        configuration.setAllowedHeaders(List.of("*"));

        //Permite el envio de credenciales
        configuration.setAllowCredentials(true);

        //Aplicar esta configuracion a todas las rutas de backen
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //Esto permite que toda la logica del backen pase a angular
        source.registerCorsConfiguration("/**", configuration);
        //se retorna el source que contiene toda esta configuracion
        return source;
    }

}
