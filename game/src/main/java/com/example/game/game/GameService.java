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
 * @param user1 Spieler 1 wird übergegben
 * @param user2 Spieler 2 wird übergeben
 */
    Game createGame(int user1, int user2);
    // toDo bitte erklären
    List<Game> getUserGames(int user);


}
