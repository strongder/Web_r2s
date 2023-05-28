package com.r2s.demo.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddressDTO {
	private String street;
	private String city;
	private String state;
	private String zipCode;
}
