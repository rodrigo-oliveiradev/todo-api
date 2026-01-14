package com.oliveiradev.todo_api.service;

import com.oliveiradev.todo_api.domain.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            // Define o algoritmo de criptografia (HMAC SHA)
            SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

            // Tempo de expiração (2 horas)
            LocalDateTime expirationTime = LocalDateTime.now().plusHours(2);
            Date expirationDate = Date.from(expirationTime.atZone(ZoneId.systemDefault()).toInstant());

            return Jwts.builder()
                    .subject(user.getEmail())
                    .claim("id", user.getId())
                    .claim("role", user.getRole())
                    .issuedAt(new Date())
                    .expiration(expirationDate) // Expira em 2h
                    .signWith(key)
                    .compact();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar token JWT", e);
        }
    }

    // Vamos usar isso depois para validar quem está entrando
    public String validateToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject(); // Retorna o e-mail se estiver tudo ok
        } catch (Exception e) {
            return null; // Token inválido ou expirado
        }
    }
}