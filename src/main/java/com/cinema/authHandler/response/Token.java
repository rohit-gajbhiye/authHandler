package com.cinema.authHandler.response;

public class Token{

	
	private String access_token;
	private String refresh_token;
	
	public Token(String accessToken, String refreshToken) {
		this.access_token = accessToken;
		this.refresh_token = refreshToken;
	}
	
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
}
