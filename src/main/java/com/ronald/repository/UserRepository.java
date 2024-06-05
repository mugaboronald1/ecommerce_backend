package com.ronald.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronald.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
	
}
