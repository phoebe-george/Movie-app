package io.springboot.movieapp.service;


import io.springboot.movieapp.domain.dto.request.MovieRequest;
import io.springboot.movieapp.domain.dto.response.MovieResponse;
import io.springboot.movieapp.domain.entity.Movie;
import io.springboot.movieapp.domain.enums.UserRole;
import io.springboot.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public MovieResponse addMovie(MovieRequest request) throws AccessDeniedException {
        System.out.println(request.getMovieName());
        if (UtilityService.getCurrentUser().getRole() != UserRole.ADMIN) {
            throw new AccessDeniedException("Only admin can add movies.");
        }
        Movie movie = new Movie(
                request.getImdbId(),
                request.getMovieName(),
                request.getType(),
                request.getYear(),
                request.getPoster(),
                Double.valueOf(request.getRate())
        );
        System.out.println(movie.getMovieName());
        return mapToResponse(movieRepository.save(movie));
    }

    public void deleteMovie(String id) throws AccessDeniedException {
        if (UtilityService.getCurrentUser().getRole() != UserRole.ADMIN) {
            throw new AccessDeniedException("Only admin can delete movies.");
        }
        movieRepository.deleteById(id);
    }

    public MovieResponse getMovieById(String id) {
        return movieRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    private MovieResponse mapToResponse(Movie movie) {
        return new MovieResponse(
                movie.getMovieName(),
                movie.getImdbId(),
                movie.getType(),
                movie.getReleaseYear(),
                movie.getPoster(),
                movie.getRate() != null ? movie.getRate().toString() : "0"
        );
    }

//    public List<MovieResponse> searchMovies(String keyword) {
//        return movieRepository.findByTitleContainingIgnoreCase(keyword).stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
}
