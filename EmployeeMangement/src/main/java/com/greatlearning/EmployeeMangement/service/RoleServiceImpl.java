package com.greatlearning.EmployeeMangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeMangement.entity.Role;
import com.greatlearning.EmployeeMangement.repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void save(Role role) {
		roleRepository.save(role);

	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();

	}

}
