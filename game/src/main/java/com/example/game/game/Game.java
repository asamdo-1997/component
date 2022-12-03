package com.example.game.game;

import com.example.game.round.Round;
import com.example.game.score.Score;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   /* @ElementCollection
    private List<Integer> userIds;*/
    private int user1;
    private int user2;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private List<Round> rounds;


    @Column
    private String category;

    @Column
    private Integer nextUser;

    @Column
    private boolean done;

    @Column
    private Integer winnerId;

    private int scorePlayer1;
    private int scorePlayer2;

}
