package io.springboot.movieapp.domain.dto.request;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRequest {
    private String imdbId ;
    private String movieName ;
    private String type ;
    private String year ;
    private String poster ;
    private String rate;
}
