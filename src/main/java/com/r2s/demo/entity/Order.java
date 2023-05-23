package com.r2s.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

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
@Table(name = "`order`")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name ="delivery_time")
	private  Date deliveryTime;
	
	@Column (name = "total")
	private BigDecimal total;
	
	@Column (name = "status")
	private String status;
	
	
	@OneToMany(mappedBy = "order")
	private Set<CartLineItem> cartLineItems;
	
	@ManyToOne
	@JoinColumn(name ="address_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	


}
