package com.r2s.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
