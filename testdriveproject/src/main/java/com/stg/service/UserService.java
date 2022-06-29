package com.stg.service;

import java.util.List;

import com.stg.model.User;

public interface UserService {
	public abstract User createUser(User user);

	public abstract User getUser(int userId);

	public abstract User updateUserById(User user, int userId);
	
	public abstract List<User> getAllUser();

	public abstract List<User> getUserByName(String userName);

}
