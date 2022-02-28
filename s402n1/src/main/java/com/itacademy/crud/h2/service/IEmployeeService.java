package com.itacademy.crud.h2.service;

import java.util.List;

import com.itacademy.crud.h2.model.Employee;

public interface IEmployeeService {

	Employee createEmployee(Employee e);
	
	Employee updateEmployee(Employee e);
	
	List<Employee> getAllEmployee();
	
	List<Employee> getAllEmployeeByJob(String job);
	
	Employee getEmployeeById(long employeeId);
	
	void deleteEmployee(long id);
}
