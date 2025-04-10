package io.springboot.movieapp.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Movie {
    @Id
    @Column(unique = true)
    private String imdbId;

    @Column(nullable = false, unique = true, name = "movie_name")
    private String movieName;


    private String type;
    @Column(name = "release_year")
    private String releaseYear;

    private String poster;

    @Column(name = "rate")
    private Double rate;

}
