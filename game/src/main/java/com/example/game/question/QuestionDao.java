package com.example.game.question;

import com.example.game.round.Question;

public interface QuestionDao {
    Question findById(int id);
}
