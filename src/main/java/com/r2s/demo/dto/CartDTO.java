package com.r2s.demo.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class CartDTO {
	private Long id;
	private BigDecimal total;
	private int numberProduct;


}
