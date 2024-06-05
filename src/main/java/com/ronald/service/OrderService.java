package com.ronald.service;

import java.util.List;

import com.ronald.exception.OrderException;
import com.ronald.model.Address;
import com.ronald.model.Order;
import com.ronald.model.User;

public interface OrderService {
 public Order createOrder(User user,Address shippingAddress);
 
 public Order findOrderById(Long orderId) throws OrderException;
 
 public List<Order> usersOrderHistory(Long userId);
 
 public Order placedOrder(Long orderId) throws OrderException;
 
 public Order confirmedOrder(Long OrderId) throws OrderException;
 
 public Order shippedOrder(Long orderId) throws OrderException;
 
 public Order deliveredOrder(Long orderId) throws OrderException;
 
 public Order cancelledOrder(Long orderId) throws OrderException;
 
 public List<Order>getAllOrders();
 
 public void deleteOrder(Long orderId) throws OrderException;
}
