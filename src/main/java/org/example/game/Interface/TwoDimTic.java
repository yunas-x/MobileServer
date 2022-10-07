package org.example.game.Interface;

import org.example.game.Player.Player;

public interface TwoDimTic extends CanTic{

    /**
     * Tics
     * @param player player who tics
     * @param i 1 coordinate
     * @param j 2 coordinate
     * @return true if ticked, otherwise false
     */
    boolean tic(Player player, int i, int j);

}
