package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class VocabServiceImplTest {

    @Autowired
    private VocabService vocabService;

    @Test
    void getQuestionsForGame() {
       var result = vocabService.getQuestionsForGame(3, "test");

        Assert.assertNotNull(result);
    }

    @Test
    void checkAnswer() {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setVocabId(1);
        answerDto.setTranslationId(1);

        vocabService.checkAnswer(answerDto);

       //Assert

    }

    @Test
    void getVocabTranslation() {
       var result =  vocabService.getVocabTranslation(1);

       Assert.assertNotNull(result);
    }



    @Test
    void importList() {

    }
}
