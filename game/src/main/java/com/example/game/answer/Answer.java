package com.example.game.answer;

import com.example.game.round.Round;
import lombok.Data;

@Data
public class Answer {

    private int id;
    private String word;
    private boolean right;
    private int vocabId;

    private Round round;
    private int userId;
}
