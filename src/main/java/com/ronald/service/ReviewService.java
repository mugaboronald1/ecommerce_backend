package com.ronald.service;

import java.util.List;

import com.ronald.exception.ProductException;
import com.ronald.model.Review;
import com.ronald.model.User;
import com.ronald.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req, User user)throws ProductException;
	
	public List<Review> getAllReview(Long ProductId);
}
