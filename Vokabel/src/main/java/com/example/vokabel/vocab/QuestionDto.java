package com.example.vokabel.vocab;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {

    private int vocabId;
    private List<Integer> translationIds;
}
