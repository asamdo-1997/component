package com.example.game.game;

import com.example.game.answer.AnswerDto;
import com.example.game.exception.ConnectionErrorException;
import com.example.game.exception.NotFoundException;
import com.example.game.feign.VocabService;
import com.example.game.round.Question;
import com.example.game.round.QuestionDto;
import com.example.game.round.Round;
import com.example.game.round.RoundDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    VocabService vocabService;
    GameRepo gameRepo;


    @Autowired
    public GameServiceImpl(VocabService vocabService, GameRepo gameRepo) {
        this.vocabService = vocabService;
        this.gameRepo = gameRepo;
    }

    @Override
    @Transactional
    public Game createGame(Integer user1, Integer user2, String category)
            throws ConnectionErrorException, NotFoundException{
        var rounds = 3;
        Game game = new Game();
        game.setUser1(user1);
        game.setUser2(user2);
        game.setCategory(category);
        game.setNextUser(user1);

        List<Question> questions;
        try {
            questions = vocabService.getQuestionsForGame(category);
        } catch (ConnectionErrorException e) {
            throw new ConnectionErrorException();
        }
        catch (NotFoundException e) {
            throw new NotFoundException("Category not found");
        }

        game.setRounds(new ArrayList<>());
        var vocabCount = 0;
        for (int i = 0; i < rounds; i++) {
            var round = new Round();
            round.setGame(game);

            List<Question> roundQuestions = new ArrayList<>();
            var perRoundAmount = 3;
            for (int x = 0; x < perRoundAmount; x++) {
                var question = questions.get(vocabCount);
                question.setRound(round);
                roundQuestions.add(question);
                vocabCount++;
            }
            round.setQuestions(roundQuestions);
            game.getRounds().add(round);
        }

        gameRepo.save(game);
        return game;
    }

    @Override
    @Transactional
    public List<Game> getUserGames(int user) {
        return gameRepo.findAllByUser1EqualsOrUser2Equals(user, user);
    }

    @Override
    @Transactional
    public Game getGameById(int userId) throws NotFoundException{
        try {
            return gameRepo.findById(userId).get();
        } catch (NotFoundException e) {
            throw new NotFoundException("Game not found");
        }
    }

    @Override
    @Transactional
    public RoundDto getCurrentRound(int gameId) throws ConnectionErrorException, NotFoundException{
        var gameOpt = gameRepo.findById(gameId);
        if (gameOpt.isEmpty()) {
            throw new NotFoundException("Game not found");
        }
       var game = gameOpt.get();
        var round = game.getRounds().stream().filter(x -> !x.isDone()).findFirst();
        if (round.isPresent()) {
            var roundDto = new RoundDto();
            roundDto.setQuestions(new ArrayList<>());
            for (var question : round.get().getQuestions()) {
                var questionDto = new QuestionDto();
                questionDto.setVocabId(question.getVocabId());
                questionDto.setAnswers(new ArrayList<>());
                questionDto.setQuestionId(question.getId());
                for (var id : question.getTranslationIds()) {
                    var answer = new AnswerDto();
                    answer.setTranslationId(id);
                    questionDto.getAnswers().add(answer);
                }
                roundDto.getQuestions().add(questionDto);
            }
            try {
                return vocabService.mapQuestion(roundDto);
            }
            catch (ConnectionErrorException e) {
                throw new ConnectionErrorException();
            }
            catch (NotFoundException e) {
                throw new NotFoundException("Category not found");
            }

        } else {
            return null;
        }
    }

}
