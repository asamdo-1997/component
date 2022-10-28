package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.translation.Translation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VocabService {

    List<QuestionDto> getQuestionsForGame(int rounds, String category);

    boolean checkAnswer(AnswerDto dto);

    List<Translation> getVocabTranslation(int vocabId);

    void addVocab(String word);

    void addTranslation(int vocabId);

    void importList(MultipartFile file,String category) throws IOException;
}
