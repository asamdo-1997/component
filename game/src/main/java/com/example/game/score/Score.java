package com.example.game.score;


import com.example.game.game.Game;
import com.example.game.round.Round;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int playerId;

    @Column
    private int count;

 /*   @ManyToOne
    @JoinColumn(name = "gameId")
    @JsonBackReference
    private Game game;*/

}
