package com.itacademy.crud.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itacademy.crud.h2.exception.EmployeeBodyFormatException;
import com.itacademy.crud.h2.exception.EmployeeNotFoundException;
import com.itacademy.crud.h2.exception.JobNotExistingException;
import com.itacademy.crud.h2.model.Employee;
import com.itacademy.crud.h2.model.Jobs;
import com.itacademy.crud.h2.repository.IEmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeRepository repo;
	
	
	@Override
	public Employee createEmployee(Employee e) {
		//dar formato correcto al input de "job"
		if(e.getJob()==null || e.getName()==null || e.getName().equals("")) {
			throw new EmployeeBodyFormatException("Service layer: take care of this unexpected exception");
		}
		String formatJob = e.getJob().toLowerCase().trim();
		//validar si el input coincide con los tipos de job posibles
		boolean validJob = jobValidation(formatJob);
		
		if(!validJob) {
			throw new JobNotExistingException("Service layer: take care of this unexpected exception");
		}else {
			if		(formatJob.equalsIgnoreCase(Jobs.INTERN.toString())) 			e.setSalary(1000);
			else if	(formatJob.equalsIgnoreCase(Jobs.SALARYMAN.toString())) 		e.setSalary(2000);
			else if	(formatJob.equalsIgnoreCase(Jobs.MANAGER.toString())) 			e.setSalary(3000);
			else if	(formatJob.equalsIgnoreCase(Jobs.BOSS.toString())) 				e.setSalary(4000);
			
			e.setJob(formatJob);
			return repo.save(e);
		}
	}

	
	@Override
	public Employee updateEmployee(Employee e) {
		Optional<Employee> employeeDb = this.repo.findById(e.getId());
		
		if(e.getName()==null || e.getName().equals("")) {
			throw new EmployeeBodyFormatException("Name can't be null or void");
		}
		
		if(employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setName(e.getName());
			//employeeUpdate.setJob(e.getJob()); 		--> campo fijo 
			//employeeUpdate.setSalary(e.getSalary());	--> campo fijo?
			repo.save(employeeUpdate);
			return employeeUpdate;
		}else {
			throw new EmployeeNotFoundException("Service layer: take care of this unexpected exception");
		}
	}

	
	@Override
	public List<Employee> getAllEmployee() {
		return this.repo.findAll();
	}
	
	private boolean jobValidation(String job) {
		Jobs[] jobList = Jobs.values();
		
		for(Jobs j : jobList) {
			if(job.equals(j.name().toLowerCase())) return true;
		}

		return false;
	}

	
	@Override
	public List<Employee> getAllEmployeeByJob(String job) {
		
		if(!jobValidation(job)) {
			throw new JobNotExistingException("Service layer: take care of this unexpected exception");
		}
		
		return repo.findByJob(job);
	}

	
	@Override
	public Employee getEmployeeById(long employeeId) {
		Optional<Employee> employeeDb = this.repo.findById(employeeId);
		
		if(employeeDb.isPresent()) {
			return employeeDb.get();
		}else {
			throw new EmployeeNotFoundException("Service layer: take care of this unexpected exception");
		}
	}

	
	@Override
	public void deleteEmployee(long employeeId) {
		Optional<Employee> employeeDb = this.repo.findById(employeeId);
		
		if(employeeDb.isPresent()) {
			this.repo.delete(employeeDb.get());
		}else {
			throw new EmployeeNotFoundException("Service layer: take care of this unexpected exception");
		}
	}
}
