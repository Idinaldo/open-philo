package com.openphilosophy.api.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.openphilosophy.api.models.game.Game;
import com.openphilosophy.api.models.game.GameMapper;
import com.openphilosophy.api.models.game.GameRegisterDTO;
import com.openphilosophy.api.repositories.GameRepository;

import java.util.UUID;

@Component
public class GameService {

    private GameMapper gameMapper;
    private GameRepository gameRepository;

    public GameService(GameMapper gameMapper, GameRepository gameRepository) {
        this.gameMapper = gameMapper;
        this.gameRepository = gameRepository;
    }

    public Game getById(String id) {
        UUID gameId = UUID.fromString(id);
        return gameRepository.findById(gameId).orElse(null);
    }

    public ResponseEntity<?> register(GameRegisterDTO data) {
        Game game = gameMapper.map(data);
        return ResponseEntity.ok(gameRepository.save(game));
    }

    public ResponseEntity<?> update(Game game) {
        return ResponseEntity.ok("under development");
    }

    public ResponseEntity<?> deleteById(String id) {
        UUID gameId = UUID.fromString(id);
        gameRepository.deleteById(gameId);
        return ResponseEntity.ok("Game deleted successfully.");
    }
}
