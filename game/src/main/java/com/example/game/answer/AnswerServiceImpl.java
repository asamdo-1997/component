package com.example.game.answer;

import com.example.game.feign.VocabService;
import com.example.game.game.GameRepo;
import com.example.game.question.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerServiceImpl implements AnswerService {

    VocabService vocabService;
    QuestionRepo questionRepo;
    AnswerRepo answerRepo;
    GameRepo gameRepo;

    @Autowired
    public AnswerServiceImpl(VocabService vocabService, QuestionRepo questionRepo, AnswerRepo answerRepo, GameRepo gameRepo) {
        this.vocabService = vocabService;
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
        this.gameRepo = gameRepo;
    }

    @Override
    @Transactional
    public AnswerResultDto checkAnswer(AnswerDto input) {
        var result = vocabService.checkAnswer(input);
        var question = questionRepo.findById(input.getQuestionId()).get();
        Answer answer = new Answer();
        answer.setUserId(input.getUserId());
        answer.setQuestion(question);
        answer.setTranslationId(input.getTranslationId());
        answer.setCorrect(result.correct);
        var correctTranslation = result.translations.stream()
                .filter(x -> question.getTranslationIds().contains(x.getId())).findFirst().get();

        answer.setCorrectTranslationId(correctTranslation.getId());
        answerRepo.save(answer);
        result.setCorrectAnswer(correctTranslation);

        //check if question is done
        if (question.getAnswer().size() > 2) {
            question.setDone(true);

        }
        //check if round is finished
        var round = question.getRound();
        var game = round.getGame();
        if (answer.isCorrect()) {

           //var game = question.getRound().getGame();
            if (game.getUser1() == input.getUserId()) {
                game.setScorePlayer1(game.getScorePlayer1() + 1);
            } else {
                game.setScorePlayer2(game.getScorePlayer2() + 1);
            }
        }
    
        if (round.getQuestions().indexOf(question) == round.getQuestions().size() - 1){

            if (game.getNextUser() == game.getUser1()) {
                game.setNextUser(game.getUser2());
            } else {
                game.setNextUser(game.getUser1());
                game.getRounds().stream().filter(x -> x.getId() == round.getId()).findFirst().get().setDone(true);
            }
        }

        if (round.isDone() && game.getRounds().stream().filter(x -> !x.isDone()).findFirst().isEmpty()) {
            game.setDone(true);
        }
        gameRepo.save(game);
        return result;
    }
}
