package com.example.game.answer;

import com.example.game.feign.VocabService;
import com.example.game.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {


    @Autowired
    VocabService vocabService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerRepo answerRepo;


    @Override
    public AnswerResultDto checkAnswer(AnswerDto input) {
        var result = vocabService.checkAnswer(input);
        var question = questionService.findById(input.getQuestionId());
        Answer answer = new Answer();
        answer.setUserId(input.getUserId());
        answer.setQuestion(question);
        answer.setTranslationId(input.getTranslationId());
        answer.setCorrect(result.correct);
        //Filter which translation was given as answer option
        var correctTranslation = result.translations.stream()
                .filter(x -> question.getTranslationIds().contains(x.getId())).findFirst().get();

        answer.setCorrectTranslationId(correctTranslation.getId());
        answerRepo.save(answer);
        result.setCorrectAnswer(correctTranslation);

        return result;
    }
}
