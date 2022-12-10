package com.example.game.question;

import com.example.game.round.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionDaoImpl implements QuestionDao {

    QuestionRepo questionRepo;

    @Autowired
    public QuestionDaoImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question findById(int id){
        return questionRepo.findById(id).get();
    }
}
