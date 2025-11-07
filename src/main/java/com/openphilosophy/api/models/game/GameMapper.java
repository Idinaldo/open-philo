package com.openphilosophy.api.models.game;

import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public Game map(GameRegisterDTO data) {
        Game game = new Game();

        game.setTitle(data.title());
        game.setCategory(data.category());
        game.setRelease(data.release());
        game.setDeveloper(data.developer());
        game.setSynopsis(data.synopsis());

        return game;
    }
}
