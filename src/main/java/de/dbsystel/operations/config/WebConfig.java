package de.dbsystel.operations.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web configuration
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Allows CORS from the React frontend component
	 * 
	 * @param registry CORS registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		        .allowedOrigins("http://localhost:3000")
		        .allowedMethods("GET", "POST", "PUT", "DELETE")
		        .allowCredentials(false)
		        .maxAge(3600);
	}
}