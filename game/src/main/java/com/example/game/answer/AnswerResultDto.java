package com.example.game.answer;

import lombok.Data;

import java.util.List;

@Data
public class AnswerResultDto {

    boolean correct;
    int vocabId;
    String vocab;
    List<TranslationDto> translations;
    TranslationDto correctAnswer;
}
