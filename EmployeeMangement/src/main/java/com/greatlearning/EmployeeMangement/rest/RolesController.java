package com.greatlearning.EmployeeMangement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeMangement.entity.Role;
import com.greatlearning.EmployeeMangement.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

	@Autowired
	RoleService roleService;

	//Get All Roles
	@GetMapping
	public List<Role> getAllRoles() {
		return roleService.findAll();
	}

	//Add Roles in database
	@PostMapping
	Role addRole(@RequestBody Role role) {
//		role.setId(0);
		roleService.save(role);
		return role;
	}

}
