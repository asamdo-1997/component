package com.example.game.game;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {

    @Autowired
    private GameService gameService;

    @Test
    void createGame() {

       Game result =  gameService.createGame(1,1);

        Assert.assertNotNull(result);
    }

    @Test
    void getUserGames() {

        var result = gameService.getUserGames(1);

        Assert.assertNotNull(result);
    }
}
