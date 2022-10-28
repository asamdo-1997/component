package com.example.game.answer;

/**
*
* Das Interface für die Antwort.
* überprüft die Antwort auf die Richtigkeit
*
* @see AnswerServiceImpl
* @author Dominik Asam, Ataullah Shinwari, Jonas Jacobsen
*
* @version 1.0
*/

/**
 * überprüft die Antwort auf die Richtigkeit
 *
 * @param answer Antwortübergabe für die Antwort
 */
public interface AnswerService {

    boolean answer(Answer answer);
}
