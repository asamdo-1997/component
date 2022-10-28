package com.example.game.round;

import com.example.game.answer.Answer;
import com.example.game.feign.Question;
import com.example.game.score.Score;
import lombok.Data;

import java.util.List;

@Data
public class Round {

    //Key ist vocabelId Value ist TranslationId der Vorschläge
    //für jede Vokabel ein Eintrag
    private List<Question> vocabs;
    private List<Answer> answers;
    private List<Score> scores;
    private boolean done;
    private Integer nextUser;


    //todo vorschläge
    //auch aus anderen Listen
}
