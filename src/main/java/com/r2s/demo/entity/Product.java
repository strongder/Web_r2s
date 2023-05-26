package com.r2s.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "created_at")
	private LocalDateTime createdAt;
	
	@Column (name = "name")
	private String name ;
	
	@Column (name = "description")
	private String description;
	
	@Column (name = "price")
	private BigDecimal price;
	
	@Column (name = "status")
	private boolean status;
	
	@Column( columnDefinition = "boolean default false")
	private boolean isDelete;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private Set<VariantProduct> variantProducts;
	


}
