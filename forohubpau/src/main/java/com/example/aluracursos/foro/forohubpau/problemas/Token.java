package com.example.aluracursos.foro.forohubpau.problemas;

import com.example.aluracursos.foro.forohubpau.modelos.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Token {
    @Value("${api.security.secret}")
    private String secret;

    public String generarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getLogin())
                .setIssuedAt(new Date())
                .setExpiration(getFechaVencimiento())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getSubject(String tokenJWT) {
        Claims claims = Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(tokenJWT)
                .getBody();
        return claims.getSubject();
    }

    private Date getFechaVencimiento() {
        return new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
    }
}
