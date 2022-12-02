package com.example.game.answer;

import com.example.game.round.Round;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;

class TranslationServiceTest {

    @Autowired
    private AnswerService answerService;

    @Test
    void answer() {
        Answer answer = new Answer();
     /*   answer.setId(1);
        answer.setTranslationId(2);
        answer.setVocabId(1);
        answer.setRound(new Round());
        answer.setUserId(1);*/

        var result = answerService.answer(answer);

        Assert.assertNotNull(answer);
    }
}
