package com.r2s.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.r2s.demo.dto.AddressDTO;
import com.r2s.demo.dto.OrderRequest;
import com.r2s.demo.dto.OrderResponse;
import com.r2s.demo.entity.Address;
import com.r2s.demo.entity.Cart;
import com.r2s.demo.entity.CartLineItem;
import com.r2s.demo.entity.Order;
import com.r2s.demo.entity.User;
import com.r2s.demo.repository.AddressRepository;
import com.r2s.demo.repository.CartRepository;
import com.r2s.demo.repository.OrderRepository;
import com.r2s.demo.repository.UserRepository;
import com.r2s.demo.service.CartService;
import com.r2s.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartService cartService;
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	@Override
	public OrderResponse placeOrder(OrderRequest orderRequest, Long cartId)
	{
		
		User user = userRepository.findById(orderRequest.getUserId()).orElse(null) ;
		Cart cart = cartRepository.findById(cartId).orElse(null);
		Address  address = addressRepository.findById(orderRequest.getAddressId()).orElse(null);
			
		Order order = new Order();
		order.setAddress(address);
		order.setDeliveryTime(orderRequest.getDeliveryTime());
		order.setUser(user);
		order.setTotal(cart.getTotal());
		order.setStatus(orderRequest.getStatus());
		orderRepository.save(order);
		
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setRecipientName(order.getUser().getFullName());
		orderResponse.setAddress(modelMapper.map(address, AddressDTO.class));
		orderResponse.setCreatedAt(order.getCreatedAt());
		orderResponse.setDeliveryTime(order.getDeliveryTime());
		orderResponse.setTotal(order.getTotal());

		Set<CartLineItem> list = new HashSet<>();
		for(CartLineItem c: order.getUser().getCart().getCartLineItems())
		{
			if (c.isDelete()==false) {
				list.add(c);
			}
		}
		orderResponse.setCartLineItems(list);
		orderResponse.setStatus(order.getStatus());
		cartService.clearCart(cartId);
		return orderResponse;
	}
		
}
