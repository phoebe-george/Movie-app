package io.springboot.movieapp.domain.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse{
    private String token;
    private String username;


}

