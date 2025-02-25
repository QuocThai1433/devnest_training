package com.devnest.auth.config;

import com.devnest.auth.dto.request.IntrospectRequest;
import com.devnest.auth.dto.response.IntrospectResponse;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.text.ParseException;
import java.util.Date;
import java.util.function.Function;

@Slf4j
@Service
public class JWTService {
    @Value("${JWT_SECRET_KEY}") // Lấy từ biến môi trường
    private String secretKey;

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) { // ✅ Thêm hàm lấy role
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateAccessToken(UserDetails userDetails, String role) { // ✅ Thêm role vào token
        return generateToken(userDetails, role, 1000 * 60 * 15); // 15 phút
    }

    public String generateRefreshToken(UserDetails userDetails, String role) { // ✅ Thêm role vào token
        return generateToken(userDetails, role, 1000 * 60 * 60 * 24 * 7); // 7 ngày
    }

    private String generateToken(UserDetails userDetails, String role, long expirationTime) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("role", role) // ✅ Lưu role vào token
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenValid(String token, String username) {
        return (extractUsername(token).equals(username) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
//    public boolean introspect(IntrospectRequest request) throws ParseException {
//        try {
//            String token = request.getToken();
//            log.info(token);
//            Claims claims = Jwts.parserBuilder()
//                    .setSigningKey(getSigningKey())
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//
//            Date expiration = claims.getExpiration();
//            boolean isValid = !expiration.before(new Date());
//
//            return isValid;
//        } catch (JwtException | IllegalArgumentException e) {
//            return false;
//        }
//    }
public IntrospectResponse introspect(IntrospectRequest request) {
    try {
        String token = request.getToken();
        log.info("Introspecting token: {}", token);

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        Date expiration = claims.getExpiration();
        boolean isValid = !expiration.before(new Date());
        log.info("isValid: {}", isValid);
        return IntrospectResponse.builder()
                .valid(isValid)
                .build();

    } catch (JwtException | IllegalArgumentException e) {
        log.error("Token validation failed: {}", e.getMessage());
        return IntrospectResponse.builder()
                .valid(false)
                .build();
    }
}

}

