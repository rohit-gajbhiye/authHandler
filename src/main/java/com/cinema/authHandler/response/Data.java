package com.cinema.authHandler.response;

public class Data {
	
	int code;
	String status;
	
	/**
	 * 
	 * @param code
	 * @param status
	 */
	public Data(int code, String status) {
		super();
		this.code = code;
		this.status = status;
	}
	
	public int getCode() {
		return code;
	}
	
	
	public String getStatus() {
		return status;
	}
	
}
