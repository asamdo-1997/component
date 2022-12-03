package com.example.game.round;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

@Data
public class QuestionDto {

    private int vocabId;
    private String name;
    private Map<Integer, String> answers;
}
