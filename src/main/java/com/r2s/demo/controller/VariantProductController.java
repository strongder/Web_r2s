package com.r2s.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.ProductDTO;
import com.r2s.demo.dto.VariantProductDTO;
import com.r2s.demo.service.ProductService;
import com.r2s.demo.service.VariantProductService;

@RestController
@RequestMapping("/variant-products")
public class VariantProductController {

	@Autowired
	private VariantProductService variantProductService;

	@GetMapping("/{id}")
	public ResponseEntity<VariantProductDTO> getById(@PathVariable Long id) {
		VariantProductDTO variantProductDTO = variantProductService.getById(id);
		return new ResponseEntity<>(variantProductDTO, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<VariantProductDTO>> getByProduct(@RequestParam("productId") Long productId) {
		List<VariantProductDTO> variantProductDTOs = variantProductService.getByProduct(productId);
		return new ResponseEntity<>(variantProductDTOs, HttpStatus.OK);
	}
	@PreAuthorize("ADMIN")
	@PostMapping()
	public ResponseEntity<VariantProductDTO> create(@RequestBody VariantProductDTO variantProductDTO) {
		VariantProductDTO result = variantProductService.create(variantProductDTO);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	@PreAuthorize("ADMIN")
	@PutMapping("/{id}")
	public ResponseEntity<VariantProductDTO> update(@PathVariable Long id,
			@RequestBody VariantProductDTO variantProductDTO) {
		VariantProductDTO result = variantProductService.update(variantProductDTO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
