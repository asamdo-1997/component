package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.translation.Translation;
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
     * @param rounds übergabe für die Anzahl der Runden
     * @param category übergabe für welche Kategrie von Fragen
     */
    List<QuestionDto> getQuestionsForGame(int rounds, String category);

    /**
     * Überprüft die Antwort
     *
     * @param dto //toDo Param bitte erklären!
     */
    boolean checkAnswer(AnswerDto dto);

    /**
     * Gibt die übersetzung der Vocabeln zurück
     *
     * @param vocabId übergabe der VocabId
     */
    List<Translation> getVocabTranslation(int vocabId);

    /**
     * hinzufügen eines Vocabels
     *
     * @param word übergabe des Wortes, welches zum Vokabeln hinzugefügt werden soll
     */
    void addVocab(String word);

    /**
     * hinzufügen von Übersetzung
     *
     * @param vocabId übergabe des Vocalebls, für welches die übersetzung hinzugefügt werden soll
     */
    void addTranslation(int vocabId);

    /**
     * //ToDo
     *
     * @param file toDO
     * @param category toDo
     */
    void importList(MultipartFile file,String category) throws IOException;
}
