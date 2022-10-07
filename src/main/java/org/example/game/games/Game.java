package org.example.game.games;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private static ArrayList<Game> games;

    @Getter(AccessLevel.PUBLIC)
    protected char result;

    // Change when add DB
    // Used to generate ID
    private static Random rnd = new Random();

    @Getter(AccessLevel.PUBLIC)
    protected int gameID; // Game ID number

    // How many steps taken in the game
    @Getter(AccessLevel.PUBLIC)
    protected int numberOfSteps;

    protected Game() {
        result = 'N';
        gameID = rnd.nextInt();
        numberOfSteps = 0;
        games.add(this);
    }
}
