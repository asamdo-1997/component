package com.example.game.game;

import java.util.List;
/**
*
* Das Interface für das Spiel.
* Erstellt das Speiel
*
* @see GameServiceImpl
* @author Dominik Asam, Ataullah Shinwari, Jonas Jacobsen
*
* @version 1.0
*/
public interface GameService {

/**
 * Übergibt die Spieler 1 und 2 und erstellt das Spiel
 * @param user1
 * @param user2
 */
    Game createGame(int user1, int user2);

    List<Game> getUserGames(int user);


}
