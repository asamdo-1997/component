package com.example.game.round;

import com.example.game.answer.AnswerDto;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class QuestionDto {

    private int vocabId;
    private String name;
    private List<AnswerDto> answers;
}
