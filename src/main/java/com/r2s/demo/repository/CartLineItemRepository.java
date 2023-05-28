package com.r2s.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.r2s.demo.entity.CartLineItem;

public interface CartLineItemRepository extends JpaRepository<CartLineItem, Long>{

	CartLineItem findByVariantProductId(Long id);

	@Query("Select count(c.id) from CartLineItem c where c.isDelete = false and c.cart.id = :id")
	int numberProduct (Long id);

	
}
