package com.openphilosophy.api.models.post;

import com.openphilosophy.api.models.game.Game;
import com.openphilosophy.api.models.movie.Movie;
import com.openphilosophy.api.models.user.User;

public record PostUpdateDTO(String title, String content, User author, String[] tags, Game[] game, Movie[] movie, Post[] comments, PostReaction[] reactions) {
}
