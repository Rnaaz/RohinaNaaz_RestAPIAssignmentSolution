package com.greatlearning.EmployeeMangement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeMangement.service.EmployeeService;
import com.greatlearning.EmployeeMangement.entity.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	// Get All Employees List
	@GetMapping
	public List<Employee> getEmployeeList() {
		return employeeService.getEmployeeList();
	}

	// Get an employee record based on the id of that employee
	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id is invalid");
		}
		return theEmployee;

	}

	// Add new Employee in the Database
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}

	// Update an existing employee record
	@PutMapping("/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		theEmployee.setFirstName(employee.getFirstName());
		theEmployee.setLastName(employee.getLastName());
		theEmployee.setEmail(employee.getEmail());
		employeeService.save(theEmployee);

	}

	// Delete an employee
	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		System.out.println(theEmployee);
		if (theEmployee == null) {
			throw new RuntimeException("The Employee Id doesn't exist");
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id - " + employeeId;

	}

	// listing all employee records sorted on their first name in either ascending
	// order or descending order .
	@GetMapping("/sort")
	public List<Employee> getEmployeeDetailsSortedByName(@RequestParam("order") String order) {

		List<Employee> employee = null;

		if (order.equalsIgnoreCase("asc")) {
			System.out.println("true");
			employee = employeeService.findAllOrderByFirstNameAsc();

		} else if (order.equalsIgnoreCase("desc")) {
			employee = employeeService.findAllOrderByFirstNameDesc();
		}

		return employee;
	}

	// Get an employee by his/her first name
	@GetMapping("/search/{firstName}")
	public List<Employee> getEmployeesByFirstName(@PathVariable("firstName") String firstName) {
		List<Employee> employee = employeeService.findByFirstName(firstName);
		if (employee == null) {
			throw new RuntimeException("Employee not found");
		}
		return employee;
	}

}
