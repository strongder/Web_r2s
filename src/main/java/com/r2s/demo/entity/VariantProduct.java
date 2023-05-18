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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "variant_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VariantProduct {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "name")
	private String name ;
	
	@Column (name = "color")
	private String color;
	
	@Column (name = "size")
	private String size;
	
	@Column( columnDefinition = "boolean default false")
	private boolean isDelete;
	@OneToMany(mappedBy = "variantProduct")
	private Set<CartLineItem> cartLineItems;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	
	


}
