package com.kmb.SpringBootJWT.Util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
 
	@Value("${app.secret}")
	private String secret;
	
	//6. validate user name in token and database, expired or not 
	public boolean validateToken(String token,String username) {
		String tokenusername= getUserName(token);
		return (username.equals(tokenusername) && !isTokenExpired(token));
	}
	
	//5. validate token expired or not
	public boolean isTokenExpired(String token) {
		Date expDate = getExpireDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}
	
	//4.get subject/user name
	public String getUserName(String token) {
		return getClaims(token).getSubject();
	}

	//3.get token expire data 
	public Date getExpireDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	// 2.read claims
	public Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secret.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}

	// 1. genetare token
	public String generateToken(String subject) {
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("mahendrababu")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS256, secret.getBytes())
				.compact();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
