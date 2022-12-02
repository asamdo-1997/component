package com.example.game.question;

import com.example.game.round.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepo questionRepo;


    @Override
    public Question findById(int id){
        return questionRepo.findById(id).get();
    }
}
