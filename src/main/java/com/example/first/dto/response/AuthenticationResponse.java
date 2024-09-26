package com.example.first.dto.response;

public class AuthenticationResponse {

	boolean isAuthenticated;

	String token;

	public AuthenticationResponse() {
	}

	public AuthenticationResponse(boolean isAuthenticated, String token) {
		super();
		this.isAuthenticated = isAuthenticated;
		this.token = token;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
