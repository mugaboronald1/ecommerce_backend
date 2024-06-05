package com.ronald.service;

import com.ronald.exception.UserException;
import com.ronald.model.User;

public interface UserService {
	public User findUserById(Long userId) throws UserException;
    public User findUserProfileByJwt(String jwt) throws UserException;
}
