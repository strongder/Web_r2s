package com.r2s.demo.dto;

import java.math.BigDecimal;
import java.util.Set;

import lombok.Data;

@Data
public class CartLineItemDTO {
	private Long id;
	private int quantity;
	private Long variantProductId;
}
