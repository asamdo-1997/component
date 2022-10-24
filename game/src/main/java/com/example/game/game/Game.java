package com.example.game.game;

import com.example.game.Round;
import com.example.game.Score;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Game {

    private int id;
    private List<Integer> users;
    private Score score;
    private int roundAmount;
    private List<Round> rounds;
}
