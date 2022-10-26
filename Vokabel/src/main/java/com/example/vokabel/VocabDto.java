package com.example.vokabel;

import lombok.Data;

import java.util.List;

@Data
public class VocabDto {

    private String word;
    private List<String> translations;
}
