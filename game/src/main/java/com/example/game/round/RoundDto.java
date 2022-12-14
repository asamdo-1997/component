package com.example.game.round;

import lombok.Data;

import java.util.List;

@Data
public class RoundDto {

    private int id;
    List<QuestionDto> questions;
}
