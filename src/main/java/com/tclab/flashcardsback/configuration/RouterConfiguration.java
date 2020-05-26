package com.tclab.flashcardsback.configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;

import com.tclab.flashcardsback.handler.FlashcardsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@CrossOrigin
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> route(FlashcardsHandler handler) {
        return RouterFunctions
                .route(POST("/flashcards").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::createFlashcard)
                .andRoute(PUT("/flashcards").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::updateFlashcard)
                .andRoute(GET("/flashcards").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/flashcards/get/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(GET("/flashcards/rand").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findRandom)
                .andRoute(DELETE("/flashcards/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::delete);
    }
}
