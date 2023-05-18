package com.r2s.demo.dto;

import lombok.Data;

@Data
public class AddressDTO {
	private Long id;
	private String district;
	private String address ;
	private String province;
	private String village;
	private boolean isDelete;

}
