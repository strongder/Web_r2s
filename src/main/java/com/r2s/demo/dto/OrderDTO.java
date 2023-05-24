package com.r2s.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class OrderDTO {
	private Long id;
	private Date deliveryTime;
	private BigDecimal total;
	private String status;
	private String recipientName;
	private String address;
	private Set<CartLineItemDTO> cartLineItemDTOs;

}
