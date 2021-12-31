package com.greatlearning.EmployeeMangement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeMangement.entity.User;

@Service
public interface UserService {

	public List<User> findAll();

	public User save(User user);
}
