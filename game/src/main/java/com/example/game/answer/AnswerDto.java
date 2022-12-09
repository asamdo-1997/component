package com.example.game.answer;


import lombok.Data;

@Data
public class AnswerDto {

    private int vocabId;
    private int userId;
    private int translationId;
    private String answerValue;
    private int questionId;
}
