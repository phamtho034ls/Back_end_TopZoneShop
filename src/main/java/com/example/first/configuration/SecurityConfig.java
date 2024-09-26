package com.example.first.configuration;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//	protected static final String SIGNER_KEY = "QK1ZIZ5iRx/NHAvPQ6nj4o6RAkHNiLajQ4l6QPAAeikgQiscs2vIt4roJxQpls49";
	@Value("${signer.key}")
	String SIGNER_KEY;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		System.out.println("go to security");
		httpSecurity.authorizeHttpRequests(req -> req.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
				.requestMatchers(HttpMethod.POST, "/users/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/product/list").permitAll()
				.requestMatchers(HttpMethod.GET, "/product/category/{id}").permitAll()
				.requestMatchers(HttpMethod.GET, "/product/detail/{id}").permitAll()
				.requestMatchers(HttpMethod.GET, "/category/list").permitAll()
				.requestMatchers(HttpMethod.GET, "/category/listWithProduct").permitAll()
				.requestMatchers(HttpMethod.DELETE, "/category/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/product/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/category/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/oder/create").permitAll()
				
				.anyRequest().authenticated());
		httpSecurity.oauth2ResourceServer(oauth2 -> oauth2.jwt(JwtConfig -> JwtConfig.decoder(jwtDecoder())));
		httpSecurity.csrf(csrf -> csrf.disable());
		return httpSecurity.build();
	}

	@Bean
	JwtDecoder jwtDecoder() {
		SecretKeySpec secretKeySpec = new SecretKeySpec(SIGNER_KEY.getBytes(), "HS512");
		return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
	}
}
