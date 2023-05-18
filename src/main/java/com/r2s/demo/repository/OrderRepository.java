package com.r2s.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
