package com.tclab.flashcardsback.handler;

import com.tclab.flashcardsback.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CreateHandler {

    private FlashcardService flashcardService;

    @Autowired
    public CreateHandler(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    /**
     * This method handles the save request
     * @param request
     * @return
     */
    public Mono<ServerResponse> saveFlashcard(ServerRequest request) {
        return flashcardService.save(request);

    }
}
