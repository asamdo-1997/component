package com.example.vokabel.vocab;

import com.example.vokabel.translation.Translation;
import com.example.vokabel.translation.TranslationRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VocabServiceImplTesta {

    @Autowired
    VocabService vocabService;

    @MockBean
    VocabRepo vocabRepo;

    @MockBean
    TranslationRepo translationRepo;


    @BeforeEach
    void setUp() {

    }

    @Test
    void getQuestionsForGame() {
    /*    List<Question> result = new ArrayList<>();
        var question1 = generateQuestion();
        var question2 = generateQuestion();
        var question3 = generateQuestion();
        var question4 = generateQuestion();
        var question5 = generateQuestion();
        var question6 = generateQuestion();
        var question7 = generateQuestion();
        var question8 = generateQuestion();
        var question9 = generateQuestion();
        result.add(question1);
        result.add(question2);
        result.add(question3);
        result.add(question4);
        result.add(question5);
        result.add(question6);
        result.add(question7);
        result.add(question8);
        result.add(question9);

        var vocab = new Vocab();
        vocab.setId(1);
        when(vocabRepo.findRandomByCategory("", 9)).thenReturn(Collections.singletonList(vocab));
        var translation = new Translation();
        when(translationRepo.getTranslationsForGame(27, new ArrayList<>())).thenReturn(Collections.singletonList(translation));

        (vocabService.getQuestionsForGame(""), result);
*/

    }

    private Question generateQuestion() {
        var question = new Question();
        question.setVocabId(1);
        var translations = new ArrayList<Integer>();
        translations.add(1);
        translations.add(2);
        question.setTranslationIds(translations);
        return question;
    }
}
