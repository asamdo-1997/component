package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {

    private int vocabId;
    private String name;
    private List<AnswerDto> answers;
    private int questionId;

    private Integer version;
}
