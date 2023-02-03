package com.example.game.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {
    List<Game> findAllByUser1EqualsOrUser2Equals(int user1, int user2);
}
