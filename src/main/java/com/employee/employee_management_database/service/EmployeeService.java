package com.employee.employee_management_database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.employee_management_database.model.Employee;
import com.employee.employee_management_database.repository.EmployeeRepository;


@Service
public class EmployeeService implements serviceInterface{
	
	@Autowired
	EmployeeRepository employeeRepo;
	
    @Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

    @Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepo.findAll();
	}

    @Override
	public Optional<Employee> getEmployeeById(int id) {
		
		return employeeRepo.findById(id);
	}

    @Override
	public void deleteEmployee(int id) {
		
	 employeeRepo.deleteById(id);
	}

    @Override
	public Employee updateEmployee(int id, Employee employee) {
		
//		Employee updateData=employeeRepo.findById(id).orElseThrow();
//		updateData.setName(employee.getName());
//		updateData.setAge(employee.getAge());
//		updateData.setPhoneNumber(employee.getPhoneNumber());
//		updateData.setDepartment(employee.getDepartment());
		return employeeRepo.save(employee);
	}



}
