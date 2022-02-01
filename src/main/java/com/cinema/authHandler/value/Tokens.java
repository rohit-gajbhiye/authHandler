package com.cinema.authHandler.value;

public class Tokens {

	private String accessToken;
	private String refreshToken;
	
	
	public Tokens(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}


	public String getRefreshToken() {
		return refreshToken;
	}
	
}
