package com.r2s.demo.config.mapper;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.r2s.demo.entity.Role;
import com.r2s.demo.repository.RoleRepository;

public class StringToSetRoleConverter extends AbstractConverter<Set<String>, Set<Role>>{

	@Autowired
	private RoleRepository roleRepository;
	@Override
	protected Set<Role> convert(Set<String> strings) {
		Set<Role> roles = new HashSet<>();
		strings.forEach(role ->
		{
			Optional<Role> dbRole = roleRepository.findByRoleName(role);
			if(dbRole.isPresent())
			{
				roles.add(dbRole.get());
			}else
				throw new RuntimeException("role not found");
		});
		return roles;
	}
	
	

}
