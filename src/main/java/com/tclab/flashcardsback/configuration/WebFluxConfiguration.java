package com.tclab.flashcardsback.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;

/**
 * Cors configuration
 */
@Configuration
public class WebFluxConfiguration extends WebFluxConfigurerComposite{

  @Override
  public void addCorsMappings(CorsRegistry corsRegistry) {
    corsRegistry
        .addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("*");
  }

  @Bean
  public WebFluxConfigurer corsConfigurer() {
    return new WebFluxConfiguration();
  }

}
