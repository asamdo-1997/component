package com.example.vokabel.answer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



class AnswerServiceImplTest {

    @Autowired
    private AnswerService answerService;

    @Test
    void checkAnswer() {
        AnswerDto answerDto = new AnswerDto();

       var result =  answerService.checkAnswer(answerDto);

        Assert.assertNotNull(result);
    }
}
