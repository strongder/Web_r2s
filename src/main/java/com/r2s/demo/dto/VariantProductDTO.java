package com.r2s.demo.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class VariantProductDTO {
	private Long id;
	private String name ;
	private String color;
	private BigDecimal price;
	private String size;
}
