package com.r2s.demo.service;

import com.r2s.demo.dto.CartDTO;

public interface CartService {
	
	CartDTO addProductToCart(Long variantProductId, int quantity);
	CartDTO clearCart(Long id);

}
