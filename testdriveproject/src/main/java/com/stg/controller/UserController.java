package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stg.model.User;
import com.stg.service.UserService;


@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping(value = "createuser")
	public ResponseEntity<User> createBikeModel(@RequestBody User user) {
		User newUser = userService.createUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "getUser/{userId}")
	public ResponseEntity<User> readAdmin(@PathVariable int userId) {
		User userInfo= userService.getUser(userId);
		return new ResponseEntity<User>(userInfo, HttpStatus.FOUND);
	}
	
	@GetMapping(value = "getUserByName/{userName}")
	public ResponseEntity<List<User>> readAdmin(@PathVariable String userName) {
		List<User> userInfo= userService.getUserByName(userName);
		return new ResponseEntity<List<User>>(userInfo, HttpStatus.FOUND);
	}
	
	@PutMapping(value = "updateUser/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") int userId,@RequestBody User user) {
		User user2= userService.updateUserById(user, userId);
		return new ResponseEntity<User>(user2, HttpStatus.OK);
	}

}
