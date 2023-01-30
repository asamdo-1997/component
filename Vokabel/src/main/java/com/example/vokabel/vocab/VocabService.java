package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.answer.AnswerResultDto;
import com.example.vokabel.translation.Translation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
*
* Das Interface für die Vocabeln.
*
* @see VocabServiceImpl
* @author Dominik Asam, Ataullah Shinwari, Jonas Jacobsen
*
* @version 1.0
*/

public interface VocabService {

    /**
     * Gibt die Liste Der Fragen zurück
     *
     * @param category übergabe für welche Kategrie von Fragen
     */
    List<Question> getQuestionsForGame(String category);


    @Transactional
    List<Translation> getVocabTranslation(int vocabId);

    /**
     * //ToDo
     *
     * @param content toDO
     * @param category toDo
     */
    void importList(String content, String category) throws IOException;

    Vocab findVocabById(int id);

    AnswerResultDto checkAnswer(AnswerDto answerDto);

    List<String> getAllCategories();

    RoundDto mapRound(RoundDto roundDto);
}
