package com.r2s.demo.dto;

import java.util.Set;

import lombok.Data;

@Data
public class UserDTO {
	
	private Long id;
	private String username;
	private String password;
	private String fullName;
	private String email;
	private String phone;
	
	private Set<String> roles;

}
