package io.springboot.movieapp.domain.dto.request;

import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    private String username;
    private String password;
    private String fullName;
    private String email;
}
