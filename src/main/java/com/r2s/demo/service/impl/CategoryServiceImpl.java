package com.r2s.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.r2s.demo.dto.CategoryDTO;
import com.r2s.demo.entity.Category;
import com.r2s.demo.repository.CategoryRepository;
import com.r2s.demo.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private  ModelMapper modelMapper;
	
	

	
	@Transactional(readOnly = true)
	@Override
	public List<CategoryDTO> getAll() {
		List<Category> categories =  categoryRepository.findAll();
		return categories.stream()
				.map(category -> modelMapper.map(category, CategoryDTO.class)).toList();
				//.collect(Collectors.toList());
	}
	@Transactional(readOnly = true)
	@Override
	public CategoryDTO getById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if(category.isPresent()) {
			return modelMapper.map(category, CategoryDTO.class);
		}
		else
			
		return null;
	}


	@Override
	public CategoryDTO create(CategoryDTO type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CategoryDTO update(CategoryDTO type) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
