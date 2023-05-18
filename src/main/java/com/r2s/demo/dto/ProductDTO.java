package com.r2s.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ProductDTO {
	
	private Long id;
	

	private LocalDateTime createdAt;
	
	private String name ;
	
	private String description;
	
	private BigDecimal price;
	
	private boolean status;
	
	private boolean isDelete;

}
