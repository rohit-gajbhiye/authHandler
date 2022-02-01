package com.cinema.authHandler.request;

public class RefreshToken {
	
	private String refreshToken;
	
	public RefreshToken() {}

	public RefreshToken(String refreshToken) {
		super();
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
