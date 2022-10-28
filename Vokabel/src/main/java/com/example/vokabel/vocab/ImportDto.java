package com.example.vokabel.vocab;

import com.example.vokabel.vocab.VocabDto;
import lombok.Data;

import java.util.List;

@Data
public class ImportDto {

    List<VocabDto> vocabDtos;
}
