package com.r2s.demo.service;

import com.r2s.demo.dto.OrderResponse;
import com.r2s.demo.dto.OrderRequest;

public interface OrderService {
	

	OrderResponse placeOrder(OrderRequest orderRequest, Long cartId);

}
