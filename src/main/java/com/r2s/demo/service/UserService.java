package com.r2s.demo.service;

import com.r2s.demo.dto.UserDTO;

public interface UserService extends BaseService<UserDTO, Long> {

	UserDTO getCurrentUser();

	UserDTO signUp(UserDTO userDTO);


}
