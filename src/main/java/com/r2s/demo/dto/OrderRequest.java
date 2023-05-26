package com.r2s.demo.dto;


import java.util.Date;
import java.util.Set;

import com.r2s.demo.entity.Address;

import lombok.Data;

@Data
public class OrderRequest {
	private Long userId;
	private Long addressId;
	private Date deliveryTime;
	private String status;
}
