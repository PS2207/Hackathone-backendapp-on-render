package com.lifeinweeks.backend.config.angular;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	       @Override
	       public void addCorsMappings(CorsRegistry registry) {
	          registry.addMapping("/**")
	             .allowedOrigins("https://splendid-tiramisu-9c34de.netlify.app") //Replace with your 'Netlify URL' while connection between 'frontend & backend' in production
	             .allowedMethods("GET", "POST", "PUT", "DELETE")
	             .allowedHeaders("*");
	       }
	    };
	}
}
//.allowCredentials(true)