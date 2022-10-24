package com.example.game.game;

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

    public Game createGame(int user1, int user2){
        var rounds = Integer.parseInt(roundAmount);
        Game game = new Game();
        List vocabs = vocabService.getVocabsForGame(rounds);
       game.setRounds(new ArrayList<>());
       for (int i = 0; i<rounds; i++){

       }

        return null;
    }
}
