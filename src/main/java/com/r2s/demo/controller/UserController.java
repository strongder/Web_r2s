package com.r2s.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.UserDTO;
import com.r2s.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/current-user")
	public ResponseEntity<UserDTO> getCurrentUser()
	{
		UserDTO userDTO = userService.getCurrentUser();
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	
	@PutMapping()
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO)
	{
		UserDTO result= userService.update(userDTO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO)
	{
		UserDTO result= userService.create(userDTO);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}


}
