package com.example.game.game;

import java.util.List;
import java.util.Optional;

public interface GameDao {
    void save(Game game);

    List<Game> findAllByUser(int user);

    Game findById(int userId);
}
