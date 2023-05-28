package com.r2s.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.r2s.demo.entity.Address;
import com.r2s.demo.entity.CartLineItem;

import lombok.Data;

@Data
public class OrderResponse {
	private LocalDateTime createdAt;
	private Date deliveryTime;
	private BigDecimal total;
	private String status;
	private String recipientName;
	private AddressDTO address;
	private Set<CartLineItem> cartLineItems;
}