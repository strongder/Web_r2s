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
import com.r2s.demo.util.JwtUtils;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	// generate jwt
	@PostMapping()
	public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest)
	{
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
			String token = JwtUtils.generateToken(authRequest.getUsername());
			return new ResponseEntity<>(token, HttpStatus.OK);
		
	
	}

}
