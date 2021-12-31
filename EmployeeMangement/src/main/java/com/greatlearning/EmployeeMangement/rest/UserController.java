package com.greatlearning.EmployeeMangement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeMangement.entity.User;
import com.greatlearning.EmployeeMangement.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;

	// Get All Users
	@GetMapping("/list")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	// Add a user in Database
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		user.setId(0l);
		System.out.println(user);
		return userService.save(user);
//		 return user;
		
	}

}
