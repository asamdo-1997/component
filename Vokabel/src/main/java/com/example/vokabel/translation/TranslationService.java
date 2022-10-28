package com.example.vokabel.translation;

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

/**
 * Gibt die Überseetzung zurück
 *
 * @param amount
 * @param notToUse
 */

public interface TranslationService {
    List<Translation> getTranslationsForGame(int amount, List<Integer> notToUse);
}
