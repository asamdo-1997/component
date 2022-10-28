package com.example.game.game;

import com.example.game.feign.Question;
import com.example.game.round.Round;
import com.example.game.feign.VocabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService{

    @Autowired
    VocabService vocabService;

    @Value("${rounds}")
    String roundAmount;


    @Override
    public Game createGame(int user1, int user2){
        var rounds = Integer.parseInt(roundAmount);
        Game game = new Game();
        List<Question> questions = vocabService.getQuestionsForGame(rounds);
       game.setRounds(new ArrayList<>());
       var vocabCount = 0;
       for (int i = 0; i<rounds; i++){
           var round = new Round();
           List<Question> roundQuestions = new ArrayList<>();
           for (int x = 0; x <5; x++) {
               roundQuestions.add(questions.get(vocabCount));
               vocabCount++;
           }
           round.setVocabs(roundQuestions);
       }

        return game;
    }

    @Override
    public List<Game> getUserGames(int user) {
        return null;
    }
}
