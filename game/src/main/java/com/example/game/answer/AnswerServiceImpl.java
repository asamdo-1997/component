package com.example.game.answer;

import com.example.game.feign.VocabService;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerServiceImpl implements AnswerService{


    @Autowired
    VocabService vocabService;


    @Override
    public int answer(Answer answer){

        return 0;
    }
}
