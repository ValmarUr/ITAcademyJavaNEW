package com.itacademy.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.itacademy.crud.h2.exception.EmployeeBodyFormatException;
import com.itacademy.crud.h2.exception.EmployeeNotFoundException;
import com.itacademy.crud.h2.exception.JobNotExistingException;
import com.itacademy.crud.h2.model.Employee;
import com.itacademy.crud.h2.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name="Employee Management Application")
@Api(tags="Employee Controller")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeServiceImpl;
	
	
	@ApiOperation(value = "Get all employees data")
	@ApiResponse(code = 500, message = "Internal Server Error")
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok().body(employeeServiceImpl.getAllEmployee());
	}
	
	
	@ApiOperation(value = "Get an employee's data")
	@ApiResponse(code = 500, message = "Internal Server Error")
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		
		try {
			return ResponseEntity.ok().body(employeeServiceImpl.getEmployeeById(id));
		}catch(EmployeeNotFoundException exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found with id:" + id, exception);
		}
	}
	
	
	
	//EXTRA METHOD
	@ApiOperation(value = "Get all employees data with selected job")
	@ApiResponse(code = 500, message = "Internal Server Error")
	@GetMapping("/{job}")
	public ResponseEntity<List<Employee>> getAllEmployeeByJob(@PathVariable String job){
		
		try {
			return ResponseEntity.ok().body(employeeServiceImpl.getAllEmployeeByJob(job));
		}catch(JobNotExistingException exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Search Job Options: intern, salaryman, manager and boss (lowercase)", exception);
		}
	}
	
	
	
	@ApiOperation(value = "Create a new employee")
	@ApiResponse(code = 500, message = "Internal Server Error")
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.employeeServiceImpl.createEmployee(employee));
		}catch(JobNotExistingException exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non Valid Job! Options: Intern, Salaryman, Manager and Boss", exception);
		}catch(EmployeeBodyFormatException exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non valid employee body received. Send a request body with name and job", exception);
		}
	}

	
	@ApiOperation(value = "Update an employee's data")
	@ApiResponse(code = 500, message = "Internal Server Error")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
		
		try {
			employee.setId(id);
			return ResponseEntity.ok().body(this.employeeServiceImpl.updateEmployee(employee));
		}catch(EmployeeNotFoundException exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found with id:" + id, exception);			
		}catch(EmployeeBodyFormatException exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non valid employee body received. Send a request body with name and job", exception);
		}
	}
	
	@ApiOperation(value = "Delete an employee's data")
	@ApiResponses(value = {	@ApiResponse(code = 500, message = "Internal Server Error"),
							@ApiResponse(code = 204, message = "No Content")})
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable long id){
		
		try {
			this.employeeServiceImpl.deleteEmployee(id);
			//return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (EmployeeNotFoundException exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found", exception);
		}
	}
	
	
	
//	@GetMapping(	//value = "/get-image-with-media-type",
//					value = "/employees/image",
//			 		produces = MediaType.IMAGE_JPEG_VALUE
//			 	)
//				public byte[] getImageWithMediaType() throws IOException {
//			    InputStream in = getClass()
//			      //.getResourceAsStream("/com/baeldung/produceimage/image.jpg");
//			    	.getResourceAsStream("/com/itacademy/crud/h2/gato.jpg");
//			    return IOUtils.toByteArray(in); 
//			}
}
