package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// create new employee rest api
	@PostMapping("add_new_employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	
	// view all employee rest api
	@GetMapping("view_all_employee")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	// get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long eid) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(eid),HttpStatus.OK);
	}
	// update employee restAPI
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long eid,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updatEmployee(employee, eid),HttpStatus.OK);
	}
	// delete employee by id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmplyee(@PathVariable("id") long eid){
		employeeService.deleteEmployee(eid);
		return new ResponseEntity<String>("Employee delete successfully !",HttpStatus.OK);
	}
	
	
}
