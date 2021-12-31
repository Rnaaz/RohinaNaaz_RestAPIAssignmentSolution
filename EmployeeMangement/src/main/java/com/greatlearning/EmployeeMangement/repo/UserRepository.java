package com.greatlearning.EmployeeMangement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeMangement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("FROM User u WHERE u.username = :username ")
	User getUserByUsername(String username);

}
