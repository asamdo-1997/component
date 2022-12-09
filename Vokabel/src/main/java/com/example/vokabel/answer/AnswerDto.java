package com.example.vokabel.answer;

import lombok.Data;

@Data
public class AnswerDto {

    private int vocabId;
    private int translationId;
    private String answerValue;
}
