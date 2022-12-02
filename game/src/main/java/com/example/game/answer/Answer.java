package com.example.game.answer;

import com.example.game.round.Round;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Answer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int translationId;


    @Column()
    private boolean checked;

    @Column
    private int vocabId;

    @Column
    private int userId;

    @ManyToOne
    @JoinColumn(name = "roundId")
    @JsonBackReference
    private Round round;

}
