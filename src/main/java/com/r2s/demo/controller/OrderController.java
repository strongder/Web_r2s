package com.r2s.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.OrderResponse;
import com.r2s.demo.dto.OrderRequest;
import com.r2s.demo.service.OrderService;

@RequestMapping("/orders")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/{cartId}")
	public ResponseEntity<OrderResponse> placeOrder(
			@PathVariable Long cartId,
			@RequestBody OrderRequest orderRequest
			)
	{
		OrderResponse orderDTO = orderService.placeOrder(orderRequest, cartId);
		
		return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
	}

}
