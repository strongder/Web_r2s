package com.r2s.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.r2s.demo.dto.AddressDTO;
import com.r2s.demo.entity.Address;
import com.r2s.demo.entity.User;
import com.r2s.demo.repository.AddressRepository;
import com.r2s.demo.repository.UserRepository;
import com.r2s.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	@Override
	public AddressDTO getById(Long key) {
		Optional<Address> address = addressRepository.findById(key);
		if (address.isPresent()) {
			return modelMapper.map(address, AddressDTO.class);
		}
		throw new RuntimeException("address not found");

	}

	@Transactional(readOnly = true)
	@Override
	public List<AddressDTO> getAddressByUser(Long userId) {
		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			Set<Address> addresses = user.get().getAddresses();
			return addresses.stream().map(address -> modelMapper.map(addresses, AddressDTO.class)).toList();
		} else
			throw new RuntimeException("user not found");
	}

	@Transactional
	@Override
	public AddressDTO delete(Long id) {
		Optional<Address> existedAddress = addressRepository.findById(id);
		if (existedAddress.isPresent()) {
			existedAddress.get().setDelete(true);
			Address address = addressRepository.save(existedAddress.get());
			return modelMapper.map(address, AddressDTO.class);
		}
		throw new RuntimeException("address not found");
	}

	@Override
	public AddressDTO update(AddressDTO addressDTO) {
		Optional<Address> existedAddress = addressRepository.findById(addressDTO.getId());
		if (existedAddress.isPresent()) {
			Address address = modelMapper.map(addressDTO, Address.class);
			addressRepository.save(address);
			return modelMapper.map(address, AddressDTO.class);
		}
		throw new RuntimeException("address not found");
	}

	@Override
	public AddressDTO create(Long userId, AddressDTO addressDTO) {
		User user = userRepository.findById(userId).orElse(null);
		Address address = modelMapper.map(addressDTO, Address.class);
		addressRepository.save(address);
		return modelMapper.map(address, AddressDTO.class);
	}

	@Override
	public List<AddressDTO> getAll() {

		return null;
	}

	@Override
	public AddressDTO create(AddressDTO type) {
		// TODO Auto-generated method stub
		return null;
	}

}
