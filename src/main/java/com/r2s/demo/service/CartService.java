package com.r2s.demo.service;

import java.util.List;

import com.r2s.demo.dto.CartDTO;
import com.r2s.demo.dto.CartLineItemDTO;

public interface CartService {
	
	CartDTO clearCart(Long id);
	CartDTO addProductToCart(Long cartId, CartLineItemDTO cartLineItemDTO);

}
