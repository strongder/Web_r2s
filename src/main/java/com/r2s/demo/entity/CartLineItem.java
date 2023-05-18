package com.r2s.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_line_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartLineItem {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "price")
	private BigDecimal price;
	
	@Column (name = "quantity")
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "product_variant_id")
	private VariantProduct variantProduct;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	


}
