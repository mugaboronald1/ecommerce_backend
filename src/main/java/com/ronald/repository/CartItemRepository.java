package com.ronald.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ronald.model.Cart;
import com.ronald.model.CartItem;
import com.ronald.model.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	
	
	
	
	@Query("SELECT ci From CartItem ci Where ci.cart=:cart And ci.product=:product And ci.size=:size And ci.userId=:userId")
	public CartItem isCarItemExist(@Param("cart")Cart cart,@Param("product")Product product, @Param("size")String size, @Param("userId")Long userId);
}
