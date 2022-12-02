package com.example.vokabel.answer;

import com.example.vokabel.translation.TranslationDto;
import lombok.Data;

import java.util.List;

@Data
public class AnswerResultDto {

    boolean right;
    int translation;
}
