package com.example.game.answer;

import com.example.game.round.Question;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Answer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int translationId;
    private boolean correct;
    private int userId;
    private int correctTranslationId;

    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonBackReference
    private Question question;

    @Version
    private Integer version;

}
