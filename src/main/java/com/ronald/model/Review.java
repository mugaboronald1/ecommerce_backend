package com.ronald.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String review;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private LocalDateTime createAt;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(Long id, String review, Product product, User user, LocalDateTime createAt) {
		super();
		this.id = id;
		this.review = review;
		this.product = product;
		this.user = user;
		this.createAt = createAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	
	
	
	
 
 
}
