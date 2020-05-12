package com.tclab.flashcardsback.repository;

import com.tclab.flashcardsback.model.Flashcards;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface FlashcardRepository extends ReactiveCrudRepository<Flashcards, Integer> {

  @Query("SELECT * FROM public.flashcards order by random() limit 1")
  Flux<Flashcards> findRandomFlashcard();


}

