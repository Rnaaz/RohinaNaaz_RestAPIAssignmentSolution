package com.greatlearning.EmployeeMangement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeMangement.entity.Role;

@Service
public interface RoleService {

	public List<Role> findAll();

	public void save(Role role);
}
