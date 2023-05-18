package com.r2s.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
