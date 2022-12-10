package com.example.game.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDaoImpl implements GameDao {

    GameRepo gameRepo;

    @Autowired
    public GameDaoImpl(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public void save(Game game) {
        this.gameRepo.save(game);
    }

    @Override
    public List<Game> findAllByUser(int user) {
        return gameRepo.findAllByUser1EqualsOrUser2Equals(user, user);
    }

    @Override
    public Game findById(int userId) {
        return gameRepo.findById(userId).get();
    }
}
