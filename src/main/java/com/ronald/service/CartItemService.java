package com.ronald.service;

import com.ronald.exception.CartItemException;
import com.ronald.exception.UserException;
import com.ronald.model.Cart;
import com.ronald.model.CartItem;
import com.ronald.model.Product;

public interface CartItemService {
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem)
	throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size,Long userId);

	public void removeCartItem(Long userId,Long cartItemId)throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId)throws CartItemException;
}
