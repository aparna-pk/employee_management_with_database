package com.employee.employee_management_database.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee_management_database.model.Employee;
import com.employee.employee_management_database.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/add")
	public ResponseEntity<Map<String, String>> addEmployee(@Valid @RequestBody Employee employee, BindingResult result) {

		 if (result.hasErrors()) {

	            Map<String, String> errorsMap = new HashMap<>();
	            for (ObjectError error : result.getAllErrors()) {
	                String field = ((FieldError) error).getField();
	                String message = error.getDefaultMessage();
	                errorsMap.put(field, message);
	            }

	            return ResponseEntity.badRequest().body(errorsMap);
	        }
		 employeeService.saveEmployee(employee);
		 
		return null ;
	
	}
	

	@RequestMapping("/viewEmployee")
	public List<Employee> getEmployees() {
		
		return employeeService.getAllEmployee();
	}
	

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable(value = "id") int id) 
	{
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok(HttpStatus.OK);	
	}
	

	@GetMapping("/showFormForUpdate/{id}")
	public ResponseEntity<Optional<Employee>> getUpdateData(@PathVariable(value = "id") int id) 
	{
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	


	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Map<String, String>> updateEmployee(@Valid @PathVariable int id , @RequestBody Employee updatedEmployee, BindingResult result) {

		if (result.hasErrors()) {
			
			 Map<String, String> errorsMap = new HashMap<>();
	            for (ObjectError error : result.getAllErrors()) {
	                String field = ((FieldError) error).getField();
	                String message = error.getDefaultMessage();
	                errorsMap.put(field, message);
	            }

	            return ResponseEntity.badRequest().body(errorsMap);
		}

       employeeService.updateEmployee(id, updatedEmployee);
		return null;
	}

	
	

}
