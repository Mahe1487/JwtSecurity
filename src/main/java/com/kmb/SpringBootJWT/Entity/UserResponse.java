package com.kmb.SpringBootJWT.Entity;

public class UserResponse {

	private String token;
	private String message;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserResponse(String token, String message) {
		super();
		this.token = token;
		this.message = message;
	}

	public UserResponse() {
		super();
	}

}
