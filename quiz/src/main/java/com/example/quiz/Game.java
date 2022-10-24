package com.example.quiz;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public class Game {

    private int id;
    private List<User> users;
    private Score score;
    private int roundAmount;
    private List<Round> rounds;
}
