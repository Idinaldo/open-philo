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

    public Game map(Game game, GameUpdateDTO data) {
        if (data.title() != null) game.setTitle(data.title());
        if (data.category() != null) game.setCategory(data.category());
        if (data.synopsis() != null) game.setSynopsis(data.synopsis());
        if (data.release() != null) game.setRelease(data.release());
        if (data.developer() != null) game.setDeveloper(data.developer());

        return game;
    }
}
