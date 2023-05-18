package com.r2s.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
