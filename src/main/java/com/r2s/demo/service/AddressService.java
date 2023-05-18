package com.r2s.demo.service;

import java.util.List;

import com.r2s.demo.dto.AddressDTO;

public interface AddressService extends BaseService<AddressDTO, Long>{
	
	AddressDTO create(Long userId, AddressDTO addressDTO);
	
	List<AddressDTO> getAddressByUser(Long userId);
	AddressDTO delete(Long id);
	

}
