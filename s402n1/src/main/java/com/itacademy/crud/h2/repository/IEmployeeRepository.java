package com.itacademy.crud.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itacademy.crud.h2.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Long>{

	List<Employee> findByJob(String job);
}
