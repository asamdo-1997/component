package com.example.vokabel;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VocabService {

    List<Integer> getVocabsForGame(int round);

    boolean checkAnswer(AnswerDto dto);

    void addVocab(String word);

    void addTranslation(int vocabId);

    void importList(MultipartFile file,String category) throws IOException;
}
