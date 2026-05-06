//package com.manish.security;
//
//import java.util.Date;
//
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtUtil {
//
//	private static final String SECRET=
//			"mysecuresecretkeyforjwttokenspringboot2026";
//
//    // 1. Generate Token
//    public String generateToken(String email) {
//
//        return Jwts.builder()
//                .setSubject(email)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
//                .signWith(SignatureAlgorithm.HS256, SECRET)
//                .compact();
//    }
//
//    // 2. Extract Email
//    public String extractEmail(String token) {
//
//        return Jwts.parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    // 3. Validate Token
//    public boolean validateToken(String token, String email) {
//
//        String extractedEmail = extractEmail(token);
//        return extractedEmail.equals(email);
//    }
//}

package com.manish.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // Minimum 32 characters required for HS256
    private static final String SECRET =
            "myverysecuresecretkeyforjwttokenspringboot2026project";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // 1. Generate Token
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 2. Extract Email
    public String extractEmail(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 3. Validate Token
    public boolean validateToken(String token, String email) {

        String extractedEmail = extractEmail(token);
        return extractedEmail.equals(email);
    }
}