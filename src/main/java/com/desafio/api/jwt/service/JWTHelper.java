/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.jwt.service;

import com.desafio.api.domain.Usuario;
import static com.desafio.api.jwt.service.TokenAuthenticationService.SECRET;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author deoprog
 */
public class JWTHelper {

    public Usuario parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            Usuario u = new Usuario();
            u.setUsername(body.getSubject());
            u.setId(Long.parseLong((String) body.get("id")));

            return u;
        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

    /**
     * Generates a JWT token containing username as subject, and userId and role
     * as additional claims. These properties are taken from the specified User
     * object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public String generateToken(Usuario u) {
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("id", u.getId() + "");

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}
