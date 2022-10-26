package com.example.game.answer;

import com.example.game.feign.VocabService;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerServiceImpl implements AnswerService{


    @Autowired
    VocabService vocabService;


    @Override
    public boolean answer(Answer answer){
        var result = vocabService.checkAnswer(answer);
        answer.setRight(result);

        //todo save result to round
        return result;
    }
}
