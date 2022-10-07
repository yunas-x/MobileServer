package org.example.game.games;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.example.game.Player.Player;
import org.example.game.Interface.CheckWinner;
import org.example.game.Interface.TwoDimTic;

public class GameOfTwoPlayers extends Game
        implements TwoDimTic, CheckWinner {

    // X - X win | O - O win
    // E - Draw | N - Not decided

    // Board
    protected int[][] matrix;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PRIVATE)
    private Player playerOne; // X player

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PRIVATE)
    private Player playerTwo; // O player

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PRIVATE)
    private Player activePlayer;

    protected GameOfTwoPlayers(Player p1, Player p2) {
        super();
        playerOne = p1;
        playerTwo = p2;
        activePlayer = playerOne;
    }

    /**
     * Checks if cell is tickable (cell is empty)
     * @param args coordinates
     * @return true if can tic, else otherwise
     * @throws RuntimeException if invalid args (length not 2)
     */
    @Override
    public boolean canTic(Integer[] args) {
        if (args.length != 2) {
            throw new RuntimeException("Passed args length greater than 2");
        }

        // Checks if coordinates are valid, game is not decided, can tick

        return IsValidCoordinate(args[0]) && IsValidCoordinate(args[1])
                && !gameIsDecided() && matrix[args[0]][args[1]] == 0;
    }

    @Override
    public boolean IsValidCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate <= matrix.length;
    }

    /**
     * Checks if game is drawn
     * @return true if drawn, otherwise false
     */
    @Override
    public boolean isDraw(){
        if (gameIsDecided()) {
            return 'E' == result;
        }
        if (numberOfSteps == 9 && result != 'O' && result != 'X') {
            checkWinner();
            if (!gameIsWon()) result = 'E';
            return 'E' == result;
        }
        return false;
    }

    /**
     * Checks if game is decided
     * @return true if game is over
     */
    @Override
    public boolean gameIsDecided() {
        return result == 'E' || gameIsWon();
    }

    /**
     * Checks if game is won
     * @return true if won, else false
     */
    @Override
    public boolean gameIsWon() {
        return result == 'O' || result == 'X';
    }

    /**
     * Checks if any player have won the game
     * Modifies result variable
     */
    @Override
    public void checkWinner() {
        if (gameIsDecided()) {
            return;
        }

        int counter = 0;
        // Try to find row of -1 or +1
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                counter += ints[j];
            }

            if (Math.abs(counter) == 3) {
                result = counter > 0 ? 'X' : 'O';
                return;
            }
        }

        // Check diagonals
        int mainDiagonal = matrix[0][0] + matrix[1][1] + matrix[2][2];
        int secondDiagonal = matrix[2][0] + matrix[1][1] + matrix[0][2];
        counter = Math.max(mainDiagonal, secondDiagonal);
        if (Math.abs(counter) == 3) {
            result = counter > 0 ? 'X' : 'O';
        }
    }

    /**
     * Makes a tick
     * @param player that makes tick
     * @param i 1st coordinate
     * @param j 2nd coordinate
     * @return true if successful, otherwise false
     */
    @Override
    public boolean tic(Player player, int i, int j) {

        // Check for invalid input, or if game is active
        if (canTic(new Integer[] {i, j})
                && player == getActivePlayer()) {
            return false;
        }

        // if player 1 then 1 (X)
        // if player 2 then -1 (O)
        matrix[i][j] = getPlayerOne() == player? 1 : -1;

        numberOfSteps += 1;
        return true;
    }
}
