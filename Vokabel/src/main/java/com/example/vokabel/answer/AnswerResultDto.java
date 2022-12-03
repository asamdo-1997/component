package com.example.vokabel.answer;

import com.example.vokabel.translation.TranslationDto;
import lombok.Data;

import java.util.List;

@Data
public class AnswerResultDto {

    boolean correct;
    int vocabId;
    String vocab;
    List<TranslationDto> translations;
}
