package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service 
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "id", id);
		}
	}


	@Override
	public Employee updatEmployee(Employee employee, long id) {
		//we need to check employee id exist in the database
		Employee exitingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		exitingEmployee.setAge(employee.getAge());
		exitingEmployee.setName(employee.getName());
		exitingEmployee.setSalary(employee.getSalary());
		employeeRepository.save(exitingEmployee);
		return exitingEmployee;
	}

	public void deleteEmployee(long id) {
		//we need to check employee id exist in the database
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

}
