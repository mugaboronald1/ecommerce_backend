package com.ronald.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronald.exception.CartItemException;
import com.ronald.exception.UserException;
import com.ronald.model.Cart;
import com.ronald.model.CartItem;
import com.ronald.model.Product;
import com.ronald.model.User;
import com.ronald.repository.CartItemRepository;
import com.ronald.repository.CartRepository;


@Service
public class CartItemServiceImplementation implements CartItemService {

	private CartItemRepository cartItemRepository;
	private UserService userService;
	private CartRepository cartRepository;
	
	public CartItemServiceImplementation(CartItemRepository cartItemRepository,UserService userService,CartRepository cartRepository) {
		this.cartItemRepository=cartItemRepository;
		this.userService=userService;
		this.cartRepository=cartRepository;
	}
	
	
	@Override
	public CartItem createCartItem(CartItem cartItem) {
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());
		
		CartItem createdCartItem=cartItemRepository.save(cartItem);
		
		return createdCartItem;
	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
		CartItem item=findCartItemById(id);
		User user=userService.findUserById(item.getUserId());
		
		if(user.getId().equals(userId)) {
			item.setQuantity(item.getQuantity());
			item.setPrice(item.getQuantity()*item.getProduct().getPrice());
			item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());
			
		}
		
		return cartItemRepository.save(item);
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
		
		CartItem carItem =cartItemRepository.isCarItemExist(cart, product, size, userId);
		return carItem;
		
	}

	@Override
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
		CartItem cartItem=findCartItemById(cartItemId);
		
		User user=userService.findUserById(cartItem.getId());
		User reqUser=userService.findUserById(userId);
		
		if(user.getId().equals(reqUser.getId())) {
			cartItemRepository.deleteById(cartItemId);
		}
		else {
			throw new UserException("You can't remove another users item");
		}
		
		
	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {
		// TODO Auto-generated method stub
		Optional<CartItem>opt =cartItemRepository.findById(cartItemId);
		if(opt.isPresent()) {
			return opt.get();
		}
		 throw new CartItemException("cartItem not founf with id:"+cartItemId);
	}

}
