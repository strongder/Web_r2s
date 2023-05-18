package com.r2s.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role>  findByRoleName(String roleName);
}
