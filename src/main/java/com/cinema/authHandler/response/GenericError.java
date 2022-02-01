package com.cinema.authHandler.response;

public class GenericError {
	
	String message;
	
	
	public GenericError() {}

	public GenericError(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
