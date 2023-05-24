package com.r2s.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.AddressDTO;
import com.r2s.demo.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/{userId}")
	public ResponseEntity<AddressDTO> create(@PathVariable Long userId, @RequestBody AddressDTO addressDTO) {
		AddressDTO result = addressService.create(userId, addressDTO);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO) {
		AddressDTO result = addressService.update(addressDTO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<AddressDTO>> getAddressByUser(@PathVariable Long userId) {
		
		List<AddressDTO> addressDTOS = addressService.getAddressByUser(userId);
		return new ResponseEntity<>(addressDTOS, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDTO> getById(@PathVariable Long id) {
		
		AddressDTO addressDTO = addressService.getById(id);
		return new ResponseEntity<>(addressDTO, HttpStatus.OK);
	}
	
	//xóa địa chỉ theo Id(xóa mềm)
	@PostMapping("/delete/{id}")
	public ResponseEntity<AddressDTO> deleteById(@PathVariable Long id) {
		
		AddressDTO addressDTO = addressService.delete(id);
		return new ResponseEntity<>(addressDTO, HttpStatus.OK);
	}

}
