package com.cinema.authHandler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cinema.authHandler.model.Authentication;

@Service
public class JWTService {
	
	
	@Autowired
	Algorithm algorithm;
	
	/**
	 * 
	 * @param auth
	 * @return
	 */
	public String generateJWT(Authentication auth) {
		String token = JWT.create().withIssuer("com.hook")
			.withSubject(auth.getUsername())
			.withClaim("type", "ACCESS_TOKEN")
			.sign(algorithm);
		return token;
	}
	
	/**
	 * 
	 * @param auth
	 * @return
	 */
	public String generateRefreshToken(Authentication auth) {
		String token = JWT.create().withIssuer("com.hook")
				.withSubject(auth.getUsername())
				.withClaim("type", "REFRESH_TOKEN")
				.sign(algorithm);
		return token;
	}
	
	/**
	 * 
	 * @param token
	 * @return
	 */
	public boolean verify(String token) {
		JWTVerifier verifier = JWT.require(algorithm)
				.withIssuer("com.hook").build();
		try {
			verifier.verify(token);
			return true;
		}catch(JWTVerificationException exception) {
			System.out.println("Failed to verify provided token"+exception.getStackTrace());
			return false;
		}
	}

}
