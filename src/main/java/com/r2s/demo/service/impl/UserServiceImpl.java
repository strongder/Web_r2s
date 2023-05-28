package com.r2s.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.r2s.demo.dto.UserDTO;
import com.r2s.demo.entity.Cart;
import com.r2s.demo.entity.User;
import com.r2s.demo.exception.UserNotFoundException;
import com.r2s.demo.repository.UserRepository;
import com.r2s.demo.service.UserService;
//import com.r2s.demo.util.BcryptUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Transactional
	@Override
	public UserDTO create(UserDTO userDTO) {
		Optional<User> existedUser = userRepository.findByUsername(userDTO.getUsername());
		if(existedUser.isPresent())
		{
			throw new UserNotFoundException("user not found"); 
		}
		else {
			User user = modelMapper.map(userDTO, User.class);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			userRepository.save(user);
			return userDTO;
		}
	}
	@Transactional
	@Override
	public UserDTO update(UserDTO userDTO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Optional<User> existedUser = userRepository.findByUsername(authentication.getName());
		if(existedUser.isPresent())
		{
			User user = modelMapper.map(userDTO, User.class);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return modelMapper.map(user, UserDTO.class);
		}
		throw new UserNotFoundException("user not found");
	}
	
	@Transactional(readOnly = true)
	@Override
	public UserDTO getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName()).orElse(null);
		return modelMapper.map(user, UserDTO
				.class);
	}

	@Override
	public List<UserDTO> getAll() {
		List<User> users = userRepository.findAll();
		
		return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
	}
	@Override
	public UserDTO getById(Long key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public UserDTO signUp(UserDTO userDTO) {
		Optional<User> existedUser = userRepository.findByUsername(userDTO.getUsername());
		if(existedUser.isPresent())
		{
			throw new UserNotFoundException("user not found"); 
		}
		else {
			Set<String> roles = new HashSet<>();
			roles.add("USER");
			userDTO.setRoles(roles);
//			userDTO.getRoles().add("USER");
			User user = modelMapper.map(userDTO, User.class);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			userRepository.save(user);
			return userDTO;
		}
	}



}