package com.openphilosophy.api.controllers;

import com.openphilosophy.api.models.movie.Movie;
import com.openphilosophy.api.models.movie.MovieRegisterDTO;
import com.openphilosophy.api.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/")
    public ResponseEntity<Movie> create(@RequestBody @Valid MovieRegisterDTO data) {
        return ResponseEntity.ok(movieService.register(data));
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movieService.findAll());
    }
}
