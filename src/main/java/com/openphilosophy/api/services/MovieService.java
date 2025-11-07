package com.openphilosophy.api.services;

import com.openphilosophy.api.models.movie.Movie;
import com.openphilosophy.api.models.movie.MovieMapper;
import com.openphilosophy.api.models.movie.MovieRegisterDTO;
import com.openphilosophy.api.repositories.MovieRepository;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    // TODO: implement read all
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie getById(String id) throws ResponseStatusException {
        UUID uuidMovie;
        try {
            uuidMovie = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ID. Please review your info and ensure the passed ID matches UUID format.");
        }
        return movieRepository.findById(uuidMovie).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie Not Found"));
    }

    public Movie register(MovieRegisterDTO data) {
        Movie movie;
        try {
            movie = movieMapper.map(data);
        } catch (Exception e) {
            throw new RuntimeException("There was an error while trying to save this movie.");
        }
        return movieRepository.save(movie);
    }

    // TODO: implement update (put)

    // TODO: implement delete

}
