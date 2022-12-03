package com.example.game.game;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepo extends JpaRepository<Game, Integer> {


    List<Game> findAllByUserIdsContains(int userId);
}
