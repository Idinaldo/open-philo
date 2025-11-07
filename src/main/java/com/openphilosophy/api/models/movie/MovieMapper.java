package com.openphilosophy.api.models.movie;

import org.springframework.stereotype.Component;

// TODO: change categories from enum values to its descriptions
// maybe this TODO should be at Movie.java
@Component
public class MovieMapper {

    public Movie map(MovieRegisterDTO data) {
        Movie movie = new Movie();

        if (data.title() != null) movie.setTitle(data.title());
        if (data.producer() != null) movie.setProducer(data.producer());
        if (data.category() != null) movie.setCategory(data.category());
        if (data.release() != null) movie.setRelease(data.release());
        if (data.castActors() != null) movie.setCastActors(data.castActors());
        if (data.synopsis() != null) movie.setSynopsis(data.synopsis());

        return movie;
    }
}
