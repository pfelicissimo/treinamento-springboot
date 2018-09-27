package br.com.opah.treinamento.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	
    	System.out.println("Configurações de cors");
    	
    	registry.addMapping("/**").allowedMethods("GET", "HEAD",
				"POST", "PUT", "DELETE", "OPTIONS", "PATCH");
    }
}