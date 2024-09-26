package com.example.first.service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.first.dto.request.AuthenRequest;
import com.example.first.dto.request.IntrospectRequest;
import com.example.first.dto.response.AuthenticationResponse;
import com.example.first.dto.response.IntrospectResponse;
import com.example.first.repository.UserRepository;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Service
public class AuthenticationService {

	private final UserRepository userRepository;

//	protected static final String SIGNER_KEY = "QK1ZIZ5iRx/NHAvPQ6nj4o6RAkHNiLajQ4l6QPAAeikgQiscs2vIt4roJxQpls49";

	@Value("${signer.key}")
	String SIGNER_KEY;
	public AuthenticationService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
		var token = request.getToken();
		JWSVerifier jwsVerifier = new MACVerifier(SIGNER_KEY.getBytes());

		SignedJWT signedJWT = SignedJWT.parse(token);

		Date expTime = signedJWT.getJWTClaimsSet().getExpirationTime();

		var verified = signedJWT.verify(jwsVerifier);

		IntrospectResponse result = new IntrospectResponse(verified && expTime.after(new Date()));

		return result;

	}

	public boolean authenticate(AuthenRequest authRequest) {
		var user = userRepository.findByUserName(authRequest.getUsername());

		PasswordEncoder encoder = new BCryptPasswordEncoder(10);

		boolean isAuthen = encoder.matches(authRequest.getPassword(), user.get().getPassWord());

		return isAuthen;
	}

	public AuthenticationResponse authenticateJWT(AuthenRequest authRequest) {
		var user = userRepository.findByUserName(authRequest.getUsername());

		PasswordEncoder encoder = new BCryptPasswordEncoder(10);
		// kiểm tra password hợp lệ
		boolean isAuthen = encoder.matches(authRequest.getPassword(), user.get().getPassWord());

		if (!isAuthen) {
			return null;
		}

		// generate token
		var token = generateToken(authRequest.getUsername());

		return new AuthenticationResponse(isAuthen, token);

	}

	public String generateToken(String username) {
		JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().subject(username).issuer("prdmg.com").issueTime(new Date())
				.expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli())).claim("role", "admin")
				.build();

		Payload payload = new Payload(claimsSet.toJSONObject());

		JWSObject jwsObject = new JWSObject(header, payload);

		try {
			jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
		} catch (KeyLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JOSEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jwsObject.serialize();
	}

}
