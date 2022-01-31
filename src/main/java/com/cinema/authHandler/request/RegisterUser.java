package com.cinema.authHandler.request;

public class RegisterUser {

	private Long id;
	private String username;
	private String password;
	private String confirmPassword;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public Long getId() {
		return id;
	}
}
