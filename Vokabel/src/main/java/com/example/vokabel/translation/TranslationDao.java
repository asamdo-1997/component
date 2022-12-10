package com.example.vokabel.translation;

import java.util.List;

/**
*
* Das Interface für die Übersetzung.
*
* @see TranslationDaoImpl
* @author Dominik Asam, Ataullah Shinwari, Jonas Jacobsen
*
* @version 1.0
*/



public interface TranslationDao {

    /**
     * Gibt die Überseetzung zurück
     * // toDo Param bitte ergänzen
     * @param amount
     * @param notToUse
     */
    List<Translation> getTranslationsForGame(int amount, List<Integer> notToUse);

}
