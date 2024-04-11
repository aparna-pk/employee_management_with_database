package com.employee.employee_management_database.service;

import java.util.List;
import java.util.Optional;

import com.employee.employee_management_database.model.Employee;

public interface serviceInterface {
	
	Employee saveEmployee(Employee employee);
	List<Employee>getAllEmployee();
	Optional<Employee> getEmployeeById(int id);
	void deleteEmployee(int id);
	Employee updateEmployee(int id , Employee employee);

}
