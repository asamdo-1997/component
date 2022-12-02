package com.example.game.feign;

import com.example.game.round.Round;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int vocabId;

    @ElementCollection
    private List<Integer> translationIds;

    @ManyToOne
    @JoinColumn(name = "roundId")
    @JsonBackReference
    private Round round;
}
