package com.r2s.demo.service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.r2s.demo.dto.OrderDTO;
import com.r2s.demo.dto.OrderRequestDTO;
import com.r2s.demo.entity.Cart;
import com.r2s.demo.entity.Order;
import com.r2s.demo.repository.CartRepository;
import com.r2s.demo.repository.OrderRepository;
import com.r2s.demo.service.CartService;
import com.r2s.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	@Override
	public OrderDTO placeOrder(OrderRequestDTO orderRequestDTO, Long cartId)
	{
		
		String recripientName = orderRequestDTO.getRecipientName();
		String address = orderRequestDTO.getAddress();
		Date deliveryTime = orderRequestDTO.getDeliveryTime();
		
		Cart cart = cartRepository.findById(cartId).orElse(null);
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setAddress(address);
		orderDTO.setDeliveryTime(deliveryTime);
		orderDTO.setRecipientName(recripientName);
		orderDTO.setTotal(cart.getTotal());
		
		Order order = modelMapper.map(orderDTO, Order.class);
		orderRepository.save(order);
		
		cartService.clearCart(cartId);
		
		return modelMapper.map(order, OrderDTO.class);
	}
		
}
