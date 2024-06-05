package com.ronald.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ronald.exception.ProductException;
import com.ronald.model.Product;
import com.ronald.service.ProductService;

@RequestMapping("/api/products")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products?")
	public ResponseEntity<Page<Product>>findProductByCategoryHandler(
	@RequestParam String category,@RequestParam List<String>color,@RequestParam List<String>size,@RequestParam Integer minPrice,
	@RequestParam Integer maxPrice,@RequestParam Integer minDiscount,@RequestParam String sort,
	@RequestParam String stock,@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
		
		Page<Product> res=productService.getAllProduct(category, color, size, minPrice, maxPrice, minDiscount, sort, stock, pageNumber, pageSize);
		System.out.println("complete products");
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
	} 
	
	@GetMapping("/products/id/productId")
	public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId)throws ProductException{
		Product product=productService.findProductById(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}

	
	}
	

	

