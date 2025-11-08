package com.openphilosophy.api.models.post;

import com.openphilosophy.api.models.game.Game;
import com.openphilosophy.api.models.movie.Movie;
import com.openphilosophy.api.models.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostRegisterDTO(@NotBlank String content, @NotNull User author, String title, String[] tags, Game[] game, Movie[] movie) {
}
