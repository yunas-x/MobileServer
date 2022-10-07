package org.example.game.Player;

import lombok.AccessLevel;
import lombok.Getter;
import org.example.game.games.Game;

import java.util.ArrayList;

public class Player {

    private static ArrayList<Player> players = new ArrayList<Player>();

    @Getter(AccessLevel.PUBLIC)
    private String name;
    @Getter(AccessLevel.PUBLIC)
    private String login;

    @Getter(AccessLevel.PUBLIC)
    private ArrayList<Game> Games;

    public void addGame(Game game) {
        Games.add(game);
    }

    public Player(String name, String login) {
        this.name = name;
        this.login = login;
        Games = new ArrayList<Game>();

        players.add(this);
    }
}
