package com.example.vokabel.vocab;

import lombok.Data;

import java.util.Map;

@Data
public class QuestionDto {

    private int vocabId;
    private String name;
    private Map<Integer, String> answers;
}
