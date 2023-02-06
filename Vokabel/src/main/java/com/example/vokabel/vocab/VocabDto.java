package com.example.vokabel.vocab;

import lombok.Data;

import java.util.List;

@Data
public class VocabDto {

    private String word;
    private List<String> translations;

    private Integer version;
}
