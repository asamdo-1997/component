package com.example.game.round;

/**
*
* Das Interface für die Runde.
* Aktuelle Runde
*
* @see RoundServiceImpl
* @author Dominik Asam, Ataullah Shinwari, Jonas Jacobsen
*
* @version 1.0
*/



public interface RoundService {
/**
 * Die aktuelle Runde des Spiels erhalten 
 * @param gameId übergabe der GameID
 */
    Round getCurrentRound(int gameId);

}
