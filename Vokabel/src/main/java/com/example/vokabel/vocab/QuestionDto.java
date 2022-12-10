package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QuestionDto {

    private int vocabId;
    private String name;
    private List<AnswerDto> answers;
    private int questionId;
}
