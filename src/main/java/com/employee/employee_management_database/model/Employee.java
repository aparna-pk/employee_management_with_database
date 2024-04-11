package com.employee.employee_management_database.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="EmployeeTable")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "must enter name")
	@Size(min = 3, max = 20, message = "name must be between 3 and 20 characters")
	@Pattern(regexp = "\\D+", message = "Field must not contain numbers")
	private String name;

	@NotBlank(message = "invalid phone number")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
	private String phoneNumber;

	@NotBlank(message = "invalid age")
	@Max(value = 80, message = "age should be less than 80")
	@Min(value = 18)
	private String age;

	@NotBlank(message = "invalid department")
	@Pattern(regexp = "\\D+", message = "Field must not contain numbers")
	private String department;

	

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", age=" + age
				+ ", department=" + department + "]";
	}


}
