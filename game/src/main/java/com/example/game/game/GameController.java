package com.example.game.game;

import com.example.game.round.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/createGame/{user1}/{user2}/{category}")
    public int createGame(@PathVariable int user1, @PathVariable int user2, @PathVariable String category){
        return gameService.createGame(user1, user2, category).getId();
    }

    @GetMapping("/userGames/{userId}")
    public List<Game> getUserGames(@PathVariable int userId){
        return gameService.getUserGames(userId);
    }

    public Round play(int gameId){
        return null;
    }


    //return transalationId
    public int answer(int questionId, int translationId){
        return  0;
    }
}
