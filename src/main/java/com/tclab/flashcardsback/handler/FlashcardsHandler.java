package com.tclab.flashcardsback.handler;

import com.tclab.flashcardsback.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class FlashcardsHandler {

    private FlashcardService flashcardService;

    @Autowired
    public FlashcardsHandler(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    /**
     * This method handles the save request
     * @param request
     * @return
     */
    public Mono<ServerResponse> save(ServerRequest request) {
        return flashcardService.save(request);
    }

    /**
     * This method handles the save request
     * @param request
     * @return
     */
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return flashcardService.findAll(request);

    }

    /**
     * This method handles the save request
     * @param request
     * @return
     */
    public Mono<ServerResponse> findById(ServerRequest request) {
        return flashcardService.findById(request);

    }

    /**
     * This method handles the save request
     * @param request
     * @return
     */
    public Mono<ServerResponse> findRandom(ServerRequest request) {
        return flashcardService.findRandom(request);

    }
}
