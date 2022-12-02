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


public interface AnswerService {

    /**
     * überprüft die Antwort auf die Richtigkeit
     *
     * @param input übergabe für die Antwort
     */

    AnswerResultDto checkAnswer(AnswerDto input);
}
