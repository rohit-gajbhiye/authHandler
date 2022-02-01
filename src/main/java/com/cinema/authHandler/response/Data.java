package com.cinema.authHandler.response;

public class Data {
	
	int code;
	String status;
	Object data;
	
	/**
	 * 
	 * @param code
	 * @param status
	 */
	public Data(int code, String status,Object data) {
		super();
		this.code = code;
		this.status = status;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	
	
	public String getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}
}
