package com.r2s.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.CategoryDTO;
import com.r2s.demo.entity.Category;
import com.r2s.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getAll()
	{
		List<CategoryDTO> categoryDTOS = categoryService.getAll();
		return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable("id") Long id) {
        CategoryDTO categoryDTO = categoryService.getById(id);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

	

}
