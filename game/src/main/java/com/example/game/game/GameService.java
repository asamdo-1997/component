package com.example.game.game;

import java.util.List;

public interface GameService {

    Game createGame(int user1, int user2);

    List<Game> getUserGames(int user);


}
