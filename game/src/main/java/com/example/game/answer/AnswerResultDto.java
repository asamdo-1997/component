package com.example.game.answer;

import lombok.Data;

import java.util.List;

@Data
public class AnswerResultDto {

    boolean right;
    List<TranslationDto> translations;
}
