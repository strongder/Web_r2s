package com.r2s.demo.service;

import com.r2s.demo.dto.OrderDTO;
import com.r2s.demo.dto.OrderRequestDTO;

public interface OrderService {
	
	OrderDTO placeOrder(OrderRequestDTO orderRequestDTO, Long cartId);

}
