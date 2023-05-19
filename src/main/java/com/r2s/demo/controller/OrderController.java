package com.r2s.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2s.demo.dto.OrderDTO;
import com.r2s.demo.dto.OrderRequestDTO;
import com.r2s.demo.entity.Order;
import com.r2s.demo.service.OrderService;

@RequestMapping("/orders")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/{cartId}")
	public ResponseEntity<OrderDTO> placeOrder(
			@PathVariable Long cartId,
			@RequestBody OrderRequestDTO orderRequestDTO
			)
	{
		OrderDTO orderDTO = orderService.placeOrder(orderRequestDTO, cartId);
		
		return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
	}
	
	

}
