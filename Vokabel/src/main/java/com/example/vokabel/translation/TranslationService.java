package com.example.vokabel.translation;

import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.answer.AnswerResultDto;

import java.util.List;

/**
*
* Das Interface für die Übersetzung.
*
* @see TranslationServiceImpl
* @author Dominik Asam, Ataullah Shinwari, Jonas Jacobsen
*
* @version 1.0
*/



public interface TranslationService {

    /**
     * Gibt die Überseetzung zurück
     * // toDo Param bitte ergänzen
     * @param amount
     * @param notToUse
     */
    List<Translation> getTranslationsForGame(int amount, List<Integer> notToUse);

}
