package com.ronald.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ronald.exception.OrderException;
import com.ronald.model.Address;
import com.ronald.model.Order;
import com.ronald.model.User;
import com.ronald.repository.CartRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	private CartRepository cartRepository;
	private CartService cartService;
	private ProductService productService;
	
	public OrderServiceImplementation(CartRepository cartRepository,CartService cartService,ProductService productService) {
		// TODO Auto-generated constructor stub
		this.cartService=cartService;
		this.cartRepository=cartRepository;
		this.productService=productService;
	}
	
	
	
	@Override
	public Order createOrder(User user, Address shippingAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderById(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> usersOrderHistory(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order placedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order confirmedOrder(Long OrderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order shippedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deliveredOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order cancelledOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		
	}

}
