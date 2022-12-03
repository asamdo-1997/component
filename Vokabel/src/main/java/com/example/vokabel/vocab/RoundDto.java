package com.example.vokabel.vocab;


import lombok.Data;

import java.util.List;

@Data
public class RoundDto {

    private int id;
    List<QuestionDto> questions;
}
