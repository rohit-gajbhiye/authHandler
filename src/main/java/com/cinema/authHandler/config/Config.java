package com.cinema.authHandler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class Config {

	
	@Bean
	public Algorithm setDefaultAlgorithmForJWT() {
		System.out.println("Initilizing default algorithm");
		return Algorithm.HMAC256("secret".getBytes());
	}
}
