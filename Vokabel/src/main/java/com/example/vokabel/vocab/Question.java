package com.example.vokabel.vocab;

import lombok.Data;

import javax.persistence.Version;
import java.util.List;

@Data
public class Question {

    private int vocabId;
    private List<Integer> translationIds;

    @Version
    private Integer version;
}
