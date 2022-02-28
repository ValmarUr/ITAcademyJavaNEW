package com.itacademy.crud.h2.exception;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException() { super();}
	
	public EmployeeNotFoundException(String exception) { super(exception);}
	
}
