package io.springboot.movieapp.domain.dto.response;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {
    private String movieName ;
    private String imdbId ;
    private String type ;
    private String year ;
    private String poster ;
    private String rate;
}
