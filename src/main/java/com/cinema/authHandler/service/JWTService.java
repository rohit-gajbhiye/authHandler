package com.cinema.authHandler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cinema.authHandler.model.Authentication;
import com.cinema.authHandler.util.AppConstants;
import com.cinema.authHandler.util.DateUtil;

@Service
public class JWTService {
	
	
	@Autowired
	Algorithm algorithm;
	
	/**
	 * 
	 * @param auth
	 * @return
	 */
	public String generateJWT(Authentication auth,String uuid) {
		String token = JWT.create().withIssuer("com.hook")
			.withSubject(auth.getUsername())
			.withClaim("type", AppConstants.ACCESS_TOKEN)
			.withClaim("id", uuid)
			.withExpiresAt(DateUtil.addMinutesToCurrentDateTime(2))
			.sign(algorithm);
		return token;
	}
	
	/**
	 * 
	 * @param auth
	 * @return
	 */
	public String generateRefreshToken(Authentication auth,String uuid) {
		String token = JWT.create().withIssuer("com.hook")
				.withSubject(auth.getUsername())
				.withClaim("type", AppConstants.REFRESH_TOKEN)
				.withClaim("id", uuid)
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
				.withIssuer("com.hook")
				.acceptExpiresAt(10)
				.build();
		try {
			verifier.verify(token);
			return true;
		}catch(JWTVerificationException exception) {
			System.out.println("Failed to verify provided token"+exception.getMessage());
			return false;
		}
	}
	
	/**
	 * 
	 * @param jwt
	 * @return
	 */
	public DecodedJWT decodeToken(String jwt) {
		JWTVerifier verifier = JWT.require(algorithm).withIssuer("com.hook").build();
		DecodedJWT token = verifier.verify(jwt);
		try {
			token = verifier.verify(token);
		}catch(JWTVerificationException exception) {
			System.out.println("Failed to verify provided token"+exception.getMessage());
		}
		return token;
	}

}
