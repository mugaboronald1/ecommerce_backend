package com.ronald.service;

import org.springframework.stereotype.Service;

import com.ronald.exception.ProductException;
import com.ronald.model.Cart;
import com.ronald.model.CartItem;
import com.ronald.model.Product;
import com.ronald.model.User;
import com.ronald.repository.CartRepository;
import com.ronald.request.AddItemRequest;

@Service
public class CartServiceImplementation implements CartService {
  private CartRepository cartRepository;
  private CartItemService cartItemService;
  private ProductService productService;
 
  public CartServiceImplementation(CartRepository cartRepository,CartItemService cartItemService,ProductService productService) {
	this.cartRepository=cartRepository;
	this.cartItemService=cartItemService;
	this.productService=productService;
}
  
	@Override
	public Cart createCart(User user) {
	
		Cart cart=new Cart();
		cart.setUser(user);
		
		return cartRepository.save(cart);
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
		Cart cart=cartRepository.findByUserId(userId);
		Product product=productService.findProductById(req.getProductId());
		
		CartItem isPresent=cartItemService.isCartItemExist(cart, product, null, userId);
		
		if(isPresent==null) {
			CartItem cartItem=new CartItem();
			cartItem.setProduct(product);
			cartItem.setCart(cart);
			cartItem.setQuantity(req.getQuantity());
			cartItem.setUserId(userId);
			
			int price=req.getQuantity()*product.getDiscountedPrice();
			cartItem.setPrice(price);
			cartItem.setSize(req.getSize());
			
			CartItem createdCartItem=cartItemService.createCartItem(cartItem);
			cart.getCartItems().add(createdCartItem);
		}
		
		return "Item Add to Cart";
	}

	@Override
	public Cart findUserCart(Long userId) {
		Cart cart=cartRepository.findByUserId(userId);
		
		int totalPrice=0;
		int totalDiscountedPrice=0;
		int totalItem=0;
		
		for(CartItem cartItem :cart.getCartItems()) {

           totalPrice=totalPrice+cartItem.getPrice();
		    totalDiscountedPrice=totalDiscountedPrice+cartItem.getDiscountedPrice();
			totalItem=totalItem+cartItem.getQuantity();
		}
		
		cart.setTotalDiscountedPrice(totalDiscountedPrice);
		cart.setTotalItem(totalItem);
		cart.setTotalPrice(totalPrice);
		cart.setDiscounte(totalPrice-totalDiscountedPrice);
		
		return cartRepository.save(cart);
		
		
	}

}
























