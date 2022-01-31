package com.cinema.authHandler.response;

public class Token extends Data{

	// Super class
	public Token(int code, String status) {
		super(code, status);
	}
	
	public Token(int code, String status,String accessToken, String refreshToken) {
		super(code, status);
		this.access_token = accessToken;
		this.refresh_token = refreshToken;
	}
	
	
	private String access_token;
	private String refresh_token;
	
	
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
