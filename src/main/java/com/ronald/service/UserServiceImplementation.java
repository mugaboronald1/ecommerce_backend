package com.ronald.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronald.config.JwtProvider;
import com.ronald.exception.UserException;
import com.ronald.model.User;
import com.ronald.repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService{
	
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	
	public UserServiceImplementation(UserRepository userRepository,JwtProvider jwtProvider) {

	this.userRepository=userRepository;
	this.jwtProvider=jwtProvider;
		
		
	}
	

	@Override
	public User findUserById(Long userId) throws UserException {
		
		Optional<User>user=userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		
		
		throw new UserException("user not found with id:" + userId) ;
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email=jwtProvider.getEmailFromToken(jwt);
		
		User user=userRepository.findByEmail(email);
		
		if(user==null) {
			throw new UserException("user not found with email"+email);
			
		}
		return user;
	}

}
















