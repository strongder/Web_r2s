package com.r2s.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
