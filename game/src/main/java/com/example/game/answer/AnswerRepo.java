package com.example.game.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer> {
}
