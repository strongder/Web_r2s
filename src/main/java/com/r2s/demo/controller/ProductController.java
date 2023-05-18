package com.r2s.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.ProductDTO;
import com.r2s.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
		ProductDTO productDTO = productService.getById(id);
		return new ResponseEntity<>(productDTO, HttpStatus.OK);
	}

	@GetMapping("/")
	// path: /products/{categoryId}?pageNum= &pageSize= $sortDir= &sortBy=
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(
			@RequestParam("categoryId") Long categoryId,
			@RequestParam("pageNum") int pageNum, 
			@RequestParam("pageSize") int pageSize,
			@RequestParam("sortDir") String sortDir, 
			@RequestParam("sortBy") String sortBy) {
		List<ProductDTO> productDTOS = productService.getProductsByCategory(categoryId, pageNum, pageSize, sortDir,
				sortBy);
		return new ResponseEntity<>(productDTOS, HttpStatus.OK);

	}

}
