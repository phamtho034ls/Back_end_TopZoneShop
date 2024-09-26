package com.example.first.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.dto.request.AuthenRequest;
import com.example.first.dto.request.IntrospectRequest;
import com.example.first.dto.response.AuthenticationResponse;
import com.example.first.dto.response.IntrospectResponse;
import com.example.first.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

	@PostMapping("/login")
	public boolean authenticate(@RequestBody AuthenRequest request) {
		return authenticationService.authenticate(request);

	}

	@PostMapping("/signin")
	public AuthenticationResponse authenticateJWT(@RequestBody AuthenRequest request) {
		var result = authenticationService.authenticateJWT(request);

		return result;
	}

	@PostMapping("/introspect")
	public IntrospectResponse introspect(@RequestBody IntrospectRequest request) throws JOSEException, ParseException {
		var result = authenticationService.introspect(request);
		return result;
	}

}
