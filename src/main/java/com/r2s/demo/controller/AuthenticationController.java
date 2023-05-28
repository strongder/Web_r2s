package com.r2s.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.AuthRequest;
import com.r2s.demo.dto.AuthResponse;
import com.r2s.demo.util.JwtUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	// generate jwt
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> generateToken(@RequestBody AuthRequest authRequest)
	{
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
			String token = JwtUtils.generateToken(authRequest.getUsername());
			AuthResponse authResponse = new AuthResponse(token, "Đăng nhập thành công");
				
			return new ResponseEntity<>(authResponse, HttpStatus.OK);
		
	
	}

}
