package com.example.game.round;

import com.example.game.answer.Answer;
import com.example.game.round.Round;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int vocabId;

    @ElementCollection
    private List<Integer> translationIds;

    @ManyToOne
    @JoinColumn(name = "roundId")
    @JsonBackReference
    private Round round;

    @OneToMany(mappedBy = "question")
    private List<Answer> answer;

    boolean done;
}
