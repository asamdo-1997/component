package com.example.game.round;

import com.example.game.Score;
import com.example.game.answer.Answer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Round {

    private List<Integer> vocabIds;
    private List<Answer> answers;
    private Score score;
}
