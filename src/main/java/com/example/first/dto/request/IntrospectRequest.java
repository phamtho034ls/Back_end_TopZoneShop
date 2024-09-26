package com.example.first.dto.request;

public class IntrospectRequest {
	private String token;

	public IntrospectRequest() {

	}

	public IntrospectRequest(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
