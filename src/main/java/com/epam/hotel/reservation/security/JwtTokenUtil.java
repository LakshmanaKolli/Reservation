package com.epam.hotel.reservation.security;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenUtil {

	private String SECRET_KEY = "secret";

	public String extractUsername(String jwt) {
		return extractClaims(jwt, Claims::getSubject);
	}

	public <T> T extractClaims(String jwt, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(jwt);
		return claimResolver.apply(claims);
	}

	public Claims extractAllClaims(String jwt) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt)
				.getBody();
	}

	public Boolean validateToken(String jwt, UserDetails userDetails) {
		final String username = extractUsername(jwt);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
	}

	public boolean isTokenExpired(String jwt) {
		return extractExpiration(jwt).before(new Date());
	}

	public Date extractExpiration(String jwt) {
		return extractClaims(jwt, Claims::getExpiration);
	}

}
