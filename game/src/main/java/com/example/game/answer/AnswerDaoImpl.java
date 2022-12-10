package com.example.game.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerDaoImpl implements AnswerDao{

    AnswerRepo answerRepo;

    @Autowired
    public AnswerDaoImpl(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    @Override
    public void save(Answer answer) {
        answerRepo.save(answer);
    }
}
