package com.r2s.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.CartDTO;
import com.r2s.demo.entity.VariantProduct;
import com.r2s.demo.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/{cartId}/{variantProductId}")
	public ResponseEntity<CartDTO> addProductByCart(
			@PathVariable Long cartId,
			@PathVariable Long variantProductId,
			@RequestParam int quantity
			)
	{
		
		CartDTO cartDTO = cartService.addProductToCart(variantProductId, variantProductId, quantity);
		return new ResponseEntity<>(cartDTO, HttpStatus.CREATED);
		
	}

}
