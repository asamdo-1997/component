package com.example.game.game;

import com.example.game.answer.AnswerDto;
import com.example.game.round.Question;
import com.example.game.feign.VocabService;
import com.example.game.round.QuestionDto;
import com.example.game.round.Round;
import com.example.game.round.RoundDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    VocabService vocabService;

    @Autowired
    GameRepo gameRepo;

    @Value("${rounds}")
    String roundAmount;


    @Value("${perRound}")
    String perRound;


    @Override
    public Game createGame(Integer user1, Integer user2, String category) {
        var rounds = Integer.parseInt(roundAmount);
        Game game = new Game();
        game.setUser1(user1);
        game.setUser2(user2);
        game.setCategory(category);
        game.setNextUser(user1);

        List<Question> questions = vocabService.getQuestionsForGame(category);
        game.setRounds(new ArrayList<>());
        var vocabCount = 0;
        for (int i = 0; i < rounds; i++) {
            var round = new Round();
            round.setGame(game);


           /* var score1 = new Score();
            score1.setPlayerId(user1);
            score1.setRound(round);

            var score2 = new Score();
            score2.setPlayerId(user2);
            score2.setRound(round);

            round.setScores(Arrays.asList(score1,score2));*/

            List<Question> roundQuestions = new ArrayList<>();
            var perRoundAmount = Integer.parseInt(perRound);
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
    public List<Game> getUserGames(int user) {
        return gameRepo.findAllByUser1EqualsOrUser2Equals(user,user);
    }

    @Override
    public Optional<Game> getGameById(int userId) {
        return gameRepo.findById(userId);
    }

    @Override
    public RoundDto getCurrentRound(int gameId){
        var game = gameRepo.findById(gameId).get();
        var round = game.getRounds().stream().filter(x -> !x.isDone()).findFirst();
        if (round.isPresent()){
            var roundDto = new RoundDto();
            roundDto.setQuestions(new ArrayList<>());
            for (var question : round.get().getQuestions()){
                var questionDto = new QuestionDto();
                questionDto.setVocabId(question.getVocabId());
                questionDto.setAnswers(new ArrayList<>());
                for (var id : question.getTranslationIds()){
                    var answer = new AnswerDto();
                    answer.setTranslationId(id);
                    questionDto.getAnswers().add(answer);
                }
                roundDto.getQuestions().add(questionDto);
            }
            return vocabService.mapQuestion(roundDto);
            //return roundDto;
        }
        else {
            return null;
        }
    }

}
