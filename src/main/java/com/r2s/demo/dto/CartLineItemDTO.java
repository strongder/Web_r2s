package com.r2s.demo.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartLineItemDTO {
	private Long id;
	private BigDecimal price;
	private int quantity;
	private String variantProductName;
	private Long variantProductId;
}
