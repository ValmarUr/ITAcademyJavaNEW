package com.itacademy.crud.h2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//IDENTITY!! --> AUTO falla generando las ID's
	private long id;
	
	@Column(name="name")
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@Column(name="job")
	@ApiModelProperty(value="4 kinds: Intern, Salaryman, Manager and Boss")
	private String job;
	
	@Column(name="salary")
	private int salary;
	
	
	public Employee() {
	}
	
	
	public Employee(long id, String name, String job, int salary) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
