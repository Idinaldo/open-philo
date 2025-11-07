package com.openphilosophy.api.controllers;

import com.openphilosophy.api.models.game.Game;
import jakarta.validation.Valid;

import com.openphilosophy.api.services.GameService;
import com.openphilosophy.api.models.game.GameRegisterDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody @Valid GameRegisterDTO data) {
        return gameService.register(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGameData(@PathVariable String id) {
        return ResponseEntity.ok(gameService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid Game game) {
        return gameService.update(game);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return gameService.deleteById(id);
    }
}
