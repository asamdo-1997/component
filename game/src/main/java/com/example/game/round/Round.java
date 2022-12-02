package com.example.game.round;

import com.example.game.answer.Answer;
import com.example.game.feign.Question;
import com.example.game.game.Game;
import com.example.game.score.Score;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Round {

    //Key ist vocabelId Value ist TranslationId der Vorschläge
    //für jede Vokabel ein Eintrag

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "round")
    private List<Question> questions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "round")
    private List<Answer> answers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "round")
    private List<Score> scores;

    @Column
    private boolean done;



    @ManyToOne
    @JoinColumn(name = "gameId")
    @JsonBackReference(value = "game")
    private Game game;


}
