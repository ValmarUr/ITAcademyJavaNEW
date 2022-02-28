package com.itacademy.crud.h2.exception;

public class JobNotExistingException extends RuntimeException{

	public JobNotExistingException() { super();}
	
	public JobNotExistingException(String exception) { super(exception);}
	
}
