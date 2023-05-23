package com.r2s.demo.service.impl;

import java.math.BigDecimal;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.r2s.demo.dto.CartDTO;
import com.r2s.demo.dto.CartLineItemDTO;
import com.r2s.demo.entity.Cart;
import com.r2s.demo.entity.CartLineItem;
import com.r2s.demo.entity.VariantProduct;
import com.r2s.demo.repository.CartLineItemRepository;
import com.r2s.demo.repository.CartRepository;
import com.r2s.demo.repository.VariantProductRepository;
import com.r2s.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private VariantProductRepository variantProductRepository;

	@Autowired
	private CartLineItemRepository cartLineItemRepository;

	@Autowired
	private ModelMapper modelMapper;

	
	@Transactional
	@Override
	public CartDTO addProductToCart(Long cartId, Long variantProductId, int quantity) {

		VariantProduct variantProduct = variantProductRepository.findById(variantProductId)
				.orElseThrow(() -> new RuntimeException("product not found"));

		CartLineItemDTO cartLineItemDTO = new CartLineItemDTO();
		cartLineItemDTO.setQuantity(quantity);
		cartLineItemDTO.setVariantProductId(variantProductId);

		CartLineItem cartLineItem = modelMapper.map(cartLineItemDTO, CartLineItem.class);
		Cart cart = cartRepository.findById(cartId).orElse(null);
		cart.getCartLineItems().add(cartLineItem);

		// tinh toan tong gia tri don hang
		BigDecimal total = calculateTotalPrice(cart.getCartLineItems());
		
		cart.setTotal(total);

		cartRepository.save(cart);

		return modelMapper.map(cart, CartDTO.class);

	}

	private BigDecimal calculateTotalPrice(Set<CartLineItem> cartLineItems) {
		BigDecimal totalPrice = BigDecimal.ZERO;

		for (CartLineItem cartItem : cartLineItems) {
			BigDecimal price = cartItem.getVariantProduct().getPrice();
			int quantity = cartItem.getQuantity();
			BigDecimal lineTotal = price.multiply(BigDecimal.valueOf(quantity));

			totalPrice = totalPrice.add(lineTotal);
		}

		return totalPrice;
	}

	@Override
	public CartDTO clearCart(Long id) {
		
		Cart cart = cartRepository.findById(id).orElse(null);
		Set<CartLineItem> list = cart.getCartLineItems();
		for(CartLineItem cartItem : list)
		{
			cartItem.setDelete(true);
		}
		return modelMapper.map(cart, CartDTO.class);
	}

}
