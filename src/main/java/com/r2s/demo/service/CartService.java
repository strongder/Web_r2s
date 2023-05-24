package com.r2s.demo.service;

import com.r2s.demo.dto.CartDTO;

public interface CartService {
	
	CartDTO clearCart(Long id);
	CartDTO addProductToCart(Long cartId, Long variantProductId, int quantity);

}
