package com.r2s.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.CartLineItem;

public interface CartLineItemRepository extends JpaRepository<CartLineItem, Long>{

}
