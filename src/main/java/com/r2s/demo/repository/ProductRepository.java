package com.r2s.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.Category;
import com.r2s.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Page<Product> findByCategory(Optional<Category> category, Pageable pageable);

}
