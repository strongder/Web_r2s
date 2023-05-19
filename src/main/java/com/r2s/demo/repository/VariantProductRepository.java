package com.r2s.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.VariantProduct;


public interface VariantProductRepository extends JpaRepository<VariantProduct, Long>{

	List<VariantProduct> findByProductId(Long productId);

}
