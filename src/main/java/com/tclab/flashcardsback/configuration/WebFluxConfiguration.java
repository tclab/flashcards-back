package com.tclab.flashcardsback.configuration;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
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

  @Bean
  CorsWebFilter corsWebFilter() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedOrigins(Arrays.asList("*"));
//    corsConfig.setMaxAge(8000L);
    corsConfig.addAllowedMethod("*");

    UrlBasedCorsConfigurationSource source =
        new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);

    return new CorsWebFilter(source);
  }

}
