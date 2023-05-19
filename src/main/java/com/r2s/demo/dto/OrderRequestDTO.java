package com.r2s.demo.dto;


import java.util.Date;

import lombok.Data;

@Data
public class OrderRequestDTO {
	private String recipientName;
	private String address;
	private Date deliveryTime;
}
