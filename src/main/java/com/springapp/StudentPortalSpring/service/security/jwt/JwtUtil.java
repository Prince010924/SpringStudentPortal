package com.springapp.StudentPortalSpring.service.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtUtil implements Serializable {

    public static final long JWT_TOKEN_VALIDITY = 120 * 60 * 1000;

    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static final String AUTHORITIES_KEY = "roles";

    /**
     * This method gets the student number from the token
     * @param token The JWT token
     * @return The email from the token
     */
    public String getStudentNumFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * This method gets the expiration date from the token.
     * @param token The JWT token.
     * @return The expiration date of the token.
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * This method gets the authorities from the token.
     * @param token The JWT token.
     * @param claimsResolver The claim's resolver.
     * @param <T> The type of the claim's resolver.
     * @return The claims.
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);

        return claimsResolver.apply(claims);
    }

    /**
     * This method gets the authorities from the token.
     * @param token The JWT token.
     * @return The authorities.
     */
    private Claims getAllClaimsFromToken(String token) {
        return io.jsonwebtoken.Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    /**
     * This method checks if the token is expired.
     * @param token The JWT token.
     * @return The authorities.
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);

        return expiration.before(new Date());
    }

    /**
     * This method generates the JWT token.
     * @param authentication The authentication.
     * @return The JWT token.
     */
    public String generateToken(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(key)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .compact();
    }

    /**
     * This method checks if the token is valid.
     * @param token The JWT token.
     * @param userDetails The user details.
     * @return The validity status of the token.
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getStudentNumFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * This method returns the authentication token.
     * @param token The JWT token.
     * @param existingAuth The existing authentication.
     * @param userDetails The user details.
     * @return The authentication token.
     */
    UsernamePasswordAuthenticationToken getAuthenticationToken(final String token, final Authentication existingAuth, final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = claimsJws.getBody();

        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }
}
