package com.example.game.answer;

import com.example.game.round.Round;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Answer {

    private int id;
    private String word;
    private boolean right;

    private Round round;
    private int userId;
}
