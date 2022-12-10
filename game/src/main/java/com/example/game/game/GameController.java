package com.example.game.game;

import com.example.game.answer.AnswerDto;
import com.example.game.answer.AnswerResultDto;
import com.example.game.answer.AnswerService;
import com.example.game.round.Round;
import com.example.game.round.RoundDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
@CrossOrigin()
@Log4j2
public class GameController {

    GameService gameService;
    AnswerService answerService;

    @Autowired
    public GameController(GameService gameService, AnswerService answerService) {
        this.gameService = gameService;
        this.answerService = answerService;
    }

    @GetMapping("/createGame/{user1}/{user2}/{category}")
    public int createGame(@PathVariable int user1, @PathVariable int user2, @PathVariable String category){
        return gameService.createGame(user1, user2, category).getId();
    }

    @GetMapping("/userGames/{userId}")
    public List<Game> getUserGames(@PathVariable int userId){
        return gameService.getUserGames(userId);
    }

    @GetMapping("/getgamebyid/{userId}")
    public Game getGameById(@PathVariable int userId){
        return gameService.getGameById(userId);
    }

    public Round play(int gameId){
        return null;
    }


    @PostMapping("/check")
    public AnswerResultDto checkAnswer(@RequestBody AnswerDto input){
        return answerService.checkAnswer(input);
    }
    //return transalationId

    @GetMapping("/currentround/{gameId}")
    public RoundDto getCurrentRound(@PathVariable int gameId){
        return gameService.getCurrentRound(gameId);
    }

}
