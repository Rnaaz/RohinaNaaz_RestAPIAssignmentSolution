package com.greatlearning.EmployeeMangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeMangement.entity.User;
import com.greatlearning.EmployeeMangement.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
