package com.tclab.flashcardsback.service;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.tclab.flashcardsback.model.Flashcards;
import com.tclab.flashcardsback.repository.FlashcardRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class FlashcardService {
  private FlashcardRepository repository;

  @Autowired
  public FlashcardService(FlashcardRepository repository) {
    this.repository = repository;
  }

  /**
   * This method save in the table the element in the request
   *
   * @param request
   * @return
   */
  public Mono<ServerResponse> createFlashcard(ServerRequest request) {
    return ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(request.bodyToMono(Flashcards.class)
            .flatMap(repository::save), Flashcards.class);
  }

  /**
   * This method save in the table the element in the request
   *
   * @param request
   * @return
   */
  public Mono<ServerResponse> updateFlashcard(ServerRequest request) {
    return ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(request.bodyToMono(Flashcards.class)
            .flatMap(repository::save), Flashcards.class);
  }

  /**
   * Get a list of flashcards (all)
   * @param request
   * @return
   */
  public Mono<ServerResponse> findAll(ServerRequest request) {
    return ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(repository.findAll(), Flashcards.class);
  }


  /**
   * Get a list of flashcards (all)
   * @param request
   * @return
   */
  public Mono<ServerResponse> findById(ServerRequest request) {
    int id = Integer.parseInt(Optional.of(request.pathVariable("id")).orElse("-1"));

    return ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(repository.findById(id), Flashcards.class);
  }

  /**
   * Get a list of flashcards (all)
   * @param request
   * @return
   */
  public Mono<ServerResponse> findRandom(ServerRequest request) {
    return ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(repository.findRandomFlashcard(), Flashcards.class);
  }

  /**
   * Get a list of flashcards (all)
   * @param request
   * @return
   */
  public Mono<ServerResponse> delete(ServerRequest request) {
    int id = Integer.parseInt(
        Optional
            .of(request.pathVariable("id"))
            .orElse("-1"));

    return ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(repository.deleteById(id), Flashcards.class);
  }

}
