package com.example.game.game;

import com.example.game.round.RoundDto;

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

    Game createGame(Integer user1, Integer user2, String category);

    /**
     * Sucht alle spiele die ein User aktuell speilt
     * @param user Spieler nach dem gesucht wird
     */
    List<Game> getUserGames(int user);


    RoundDto getCurrentRound(int gameId);
}
