package com.greatlearning.EmployeeMangement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeMangement.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getEmployeeList();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

	public List<Employee> findAllOrderByFirstNameAsc();

	public List<Employee> findAllOrderByFirstNameDesc();

	public List<Employee> findByFirstName(String firstName);

}
