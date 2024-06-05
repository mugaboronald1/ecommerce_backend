package com.ronald.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronald.exception.OrderException;
import com.ronald.exception.UserException;
import com.ronald.model.Address;
import com.ronald.model.Order;
import com.ronald.model.User;
import com.ronald.service.OrderService;
import com.ronald.service.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderControl {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<Order>createOrder(@RequestBody Address shippingAddress, @RequestHeader("Authorization")String jwt)throws UserException{
		
		User user=userService.findUserProfileByJwt(jwt);
		Order order=orderService.createOrder(user, shippingAddress);
		
		System.out.println("order"+order);
		
		return new ResponseEntity<Order>(order,HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<Order>>usersOrderHistory(@RequestHeader("Authorization")String jwt)throws UserException{
	
		User user=userService.findUserProfileByJwt(jwt);
		List<Order>orders=orderService.usersOrderHistory(user.getId());
		
		return new ResponseEntity<>(orders,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Order>findOrderById(@PathVariable("Id") Long orderId,@RequestHeader("Authorization")String jwt)throws UserException,OrderException{
		
		User user=userService.findUserProfileByJwt(jwt);
		Order order=orderService.findOrderById(orderId);
		
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
	
	
	
}













