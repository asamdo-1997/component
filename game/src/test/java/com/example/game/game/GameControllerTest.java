package com.example.game.game;

import com.example.game.answer.AnswerDto;
import com.example.game.answer.AnswerResultDto;
import com.example.game.answer.AnswerService;
import com.example.game.round.RoundDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Log4j2
class GameControllerTest {
    GameService gameService;
    AnswerService answerService;

    @BeforeEach
    void setUp() {
        gameService = new GameService() {
            @Override
            public Game createGame(Integer user1, Integer user2, String category) {
                Game game = new Game();
                game.setUser1(user1);
                game.setUser2(user2);
                game.setCategory(category);
                game.setNextUser(user1);
                return game;
            }

            @Override
            public List<Game> getUserGames(int user) {
                Game game = new Game();
                Game game2 = new Game();
                List<Game> user1gameList = new ArrayList<>();
                user1gameList.add(game);
                user1gameList.add(game2);
                return user1gameList;
            }

            @Override
            public Game getGameById(int gameId) {
                Game game = new Game();
                game.setId(1);
                return game;
            }

            @Override
            public RoundDto getCurrentRound(int gameId) {
                return null;
            }
        };
        answerService = new AnswerService() {
            @Override
            public AnswerResultDto checkAnswer(AnswerDto input) {
                var result = new AnswerResultDto();
                return null;
            }
        };
    }

    @Test
    void createGame() {
        String category = "test";
        int user1 = 1;
        int user2 = 2;
        Assertions.assertEquals(gameService.createGame(user1, user2, category).getCategory(), "test");
        Assertions.assertEquals(gameService.createGame(user1, user2, category).getUser1(), 1);
        Assertions.assertEquals(gameService.createGame(user1, user2, category).getUser2(), 2);

    }

    @Test
    void getUserGames() {
        int user1 = 1;
        final List<Game> listOfUserGames = gameService.getUserGames(user1);
        Assertions.assertEquals(listOfUserGames.size(), 2);
    }

    @Test
    void getGameById() {
        int gameId = 1;
        Assertions.assertEquals(gameService.getGameById(gameId).getId(), 1);
    }
}