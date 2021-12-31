package com.greatlearning.EmployeeMangement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeMangement.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
