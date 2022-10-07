package org.example.game.Control;

import lombok.Data;
import org.example.game.Player.Player;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class GameController {

    @PostMapping(value = "/player_create",
                 consumes = {MediaType.APPLICATION_JSON_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Player> postGame(@RequestBody Player player) {
        Player persistedPlayer = player;

        return ResponseEntity.created(URI.
                                        create(String.format("/players/%s",
                                                player.getLogin()))).body(player);
    }
}
