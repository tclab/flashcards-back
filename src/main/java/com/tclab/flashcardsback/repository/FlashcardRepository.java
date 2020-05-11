package com.tclab.flashcardsback.repository;

import com.tclab.flashcardsback.model.Flashcards;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FlashcardRepository extends ReactiveCrudRepository<Flashcards, Integer> {
}

