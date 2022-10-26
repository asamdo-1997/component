package com.example.game.game;

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
        List<Integer> vocabs = vocabService.getVocabsForGame(rounds);
       game.setRounds(new ArrayList<>());
       var vocabCount = 0;
       for (int i = 0; i<rounds; i++){
           var round = new Round();
           List<Integer> ids = new ArrayList<>();
           for (int x = 0; x <5; x++) {
               ids.add(vocabs.get(vocabCount));
               vocabCount++;
           }
           round.setVocabIds(ids);
       }

        return game;
    }

    @Override
    public List<Game> getUsersGame(int user) {
        return null;
    }
}
