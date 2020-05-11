package com.tclab.flashcardsback.configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

import com.tclab.flashcardsback.handler.CreateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> route(CreateHandler handler) {
        return RouterFunctions
                .route(POST("/flashcard").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::saveFlashcard);

//                .andRoute(POST("/pyme").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::saveFlashcard);
    }
}
