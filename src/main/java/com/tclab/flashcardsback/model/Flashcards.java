package com.tclab.flashcardsback.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flashcards {
    @Id
    private Integer id;
    private String front;
    private String back;
    private Float okn;
    private Float nokn;
    private String topic;
    private String subtopic;
    private Boolean enable;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}
