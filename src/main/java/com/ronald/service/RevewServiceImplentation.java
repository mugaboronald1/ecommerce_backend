package com.ronald.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ronald.exception.ProductException;
import com.ronald.model.Product;
import com.ronald.model.Review;
import com.ronald.model.User;
import com.ronald.repository.ProductRepository;
import com.ronald.repository.ReviewRepository;
import com.ronald.request.ReviewRequest;

@Service
public class RevewServiceImplentation implements ReviewService{

	private ReviewRepository reviewRepository;
	private ProductService productService;
	private ProductRepository productRepository;
	
	public RevewServiceImplentation(ReviewRepository reviewRepository,ProductService productService,ProductRepository productRepository) {
		this.reviewRepository=reviewRepository;
		this.productService=productService;
		this.productRepository=productRepository;
	}
	
	@Override
	public Review createReview(ReviewRequest req, User user) throws ProductException {
		Product product=productService.findProductById(req.getProductId());
		
		
		Review review=new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreateAt(LocalDateTime.now());
		
		
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReview(Long ProductId) {
		// TODO Auto-generated method stub
		return reviewRepository.getAllProductsReview(ProductId);
	}

}









