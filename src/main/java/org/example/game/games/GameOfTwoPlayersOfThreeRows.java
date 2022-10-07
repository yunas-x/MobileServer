package org.example.game.games;

import org.example.game.Player.Player;

/**
 * TicTacToe game of 3 rows
 */
public class GameOfTwoPlayersOfThreeRows
        extends GameOfTwoPlayers {

    // How many steps taken
    // Change when add DB
    
    /**
     * Creates new instance of game
     * @param p1 Player 1 (X, 1 in matrix)
     * @param p2 Player 2 (0, -1 matrix)
     */
    public GameOfTwoPlayersOfThreeRows(Player p1, Player p2) {
        super(p1, p2);
        matrix = new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }





}
