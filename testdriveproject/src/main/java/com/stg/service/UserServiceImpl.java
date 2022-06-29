package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.ResourceNotFoundException;
import com.stg.model.User;
import com.stg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(int userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User updateUserById(User user, int userId) {
	java.util.Optional<User> optional =userRepository.findById(userId);
		if (optional.isPresent()) {
			return userRepository.save(user);
		} else {
			throw new ResourceNotFoundException("That User is not Found");
		}
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUserByName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
