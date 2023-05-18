package com.r2s.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
