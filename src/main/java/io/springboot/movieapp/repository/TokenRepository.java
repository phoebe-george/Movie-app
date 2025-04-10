package io.springboot.movieapp.repository;

import io.springboot.movieapp.domain.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query(value = """
            SELECT t FROM Token t INNER JOIN User u\s
            ON t.user.userId = u.userId\s
            WHERE u.userId = :id AND (t.expired = false OR t.revoked = false)\s
            """)
    List<Token> findAllValidTokensByUserId(Long id);

    Optional<Token> findByToken(String token);
}
