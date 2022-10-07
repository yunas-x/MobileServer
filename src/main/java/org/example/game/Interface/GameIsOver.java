package org.example.game.Interface;

public interface GameIsOver {

    /**
     * Checks if game is over
     * @return true if over, otherwise else
     */
    boolean gameIsDecided();

    /**
     * Checks if game is drawn
     * @return true if drawn, otherwise else
     */
    boolean isDraw();

    /**
     * Checks if game is won
     * @return true if won, otherwise else
     */
    boolean gameIsWon();
}
