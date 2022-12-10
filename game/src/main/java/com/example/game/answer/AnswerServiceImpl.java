package com.example.game.answer;

import com.example.game.feign.VocabService;
import com.example.game.game.GameDao;
import com.example.game.question.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    VocabService vocabService;
    QuestionDao questionDao;
    AnswerDao answerDao;
    GameDao gameDao;

    @Autowired
    public AnswerServiceImpl(VocabService vocabService, QuestionDao questionDao, AnswerDao answerDao, GameDao gameDao) {
        this.vocabService = vocabService;
        this.questionDao = questionDao;
        this.answerDao = answerDao;
        this.gameDao = gameDao;
    }

    @Override
    public AnswerResultDto checkAnswer(AnswerDto input) {
        var result = vocabService.checkAnswer(input);
        var question = questionDao.findById(input.getQuestionId());
        Answer answer = new Answer();
        answer.setUserId(input.getUserId());
        answer.setQuestion(question);
        answer.setTranslationId(input.getTranslationId());
        answer.setCorrect(result.correct);
        //Filter which translation was given as answer option
        var correctTranslation = result.translations.stream()
                .filter(x -> question.getTranslationIds().contains(x.getId())).findFirst().get();

        answer.setCorrectTranslationId(correctTranslation.getId());
        answerDao.save(answer);
        result.setCorrectAnswer(correctTranslation);

        //check if question is done
        if (question.getAnswer().size() == 2) {
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
     //   if (question.isDone() && round.getQuestions().stream().filter(x -> !x.isDone()).findFirst().isEmpty()) {

       // if (question.isDone() && round.getQuestions().stream().filter(x -> !x.isDone()).findFirst().isEmpty()) {
        if (round.getQuestions().indexOf(question) == round.getQuestions().size() - 1){
            round.setDone(true);
        }
        if (round.getQuestions().indexOf(question) == round.getQuestions().size() - 1){

            if (game.getNextUser() == game.getUser1()) {
                game.setNextUser(game.getUser2());
            } else {
                game.setNextUser(game.getUser1());
            }
        }

        if (round.isDone() && game.getRounds().stream().filter(x -> !x.isDone()).findFirst().isEmpty()) {
            game.setDone(true);
        }
        gameDao.save(game);
        return result;
    }
}
