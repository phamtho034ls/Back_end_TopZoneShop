package com.example.first.dto.response;

public class IntrospectResponse {

	private boolean isValidToken;

	public IntrospectResponse() {
		super();
	}

	public IntrospectResponse(boolean isValidToken) {
		super();
		this.isValidToken = isValidToken;
	}

	public boolean isValidToken() {
		return isValidToken;
	}

	public void setValidToken(boolean isValidToken) {
		this.isValidToken = isValidToken;
	}

}
