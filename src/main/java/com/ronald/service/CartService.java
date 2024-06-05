package com.ronald.service;

import com.ronald.exception.ProductException;
import com.ronald.model.Cart;
import com.ronald.model.User;
import com.ronald.request.AddItemRequest;

public interface CartService {

	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);
}
