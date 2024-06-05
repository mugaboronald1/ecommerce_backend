package com.ronald.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ronald.exception.ProductException;
import com.ronald.model.Rating;
import com.ronald.model.User;
import com.ronald.request.RatingRequest;

@Service
public interface RatingService {

	public Rating createRating(RatingRequest req, User user) throws ProductException;
	
	public List<Rating>getProductsRating(Long productId);
}
