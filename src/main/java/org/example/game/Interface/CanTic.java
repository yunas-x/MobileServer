package org.example.game.Interface;

public interface CanTic extends GameIsOver {

    /**
     * Checks if you can tick
     * @param args coordinates
     * @return true if possible, otherwise false
     */
    boolean canTic(Integer[] args);

    /**
     * Checks if coordinate is valid
     * @param coordinate a coordinate
     * @return if valid true, otherwise false
     */
    boolean IsValidCoordinate(int coordinate);
}
