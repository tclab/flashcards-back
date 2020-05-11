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
public class WebFluxConfiguration {

  /**
   * Set the header Access-Control-Allow-Origin as *
   * @return
   */
  @Bean
  public WebFluxConfigurer corsConfigurer() {
    return new WebFluxConfigurerComposite() {

      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
            .allowedMethods("*");
      }
    };
  }
}
