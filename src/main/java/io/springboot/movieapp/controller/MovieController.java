package io.springboot.movieapp.controller;

import io.springboot.movieapp.domain.dto.request.MovieRequest;
import io.springboot.movieapp.domain.dto.response.MovieResponse;
import io.springboot.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieResponse> getAll() {
        return movieService.getAllMovies();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody MovieRequest movie) throws AccessDeniedException {
        try {
            return ResponseEntity.ok(movieService.addMovie(movie));
        }
        catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only admin can add movies.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable String id) throws AccessDeniedException {
        try {
            movieService.deleteMovie(id);
            return ResponseEntity.ok("Deleted Successfully");
        }
        catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only admin can add movies.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetails(@PathVariable String id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
}
