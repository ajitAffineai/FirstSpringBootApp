package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

//In Java, an interface can extend one or more other interfaces.
//This concept is known as interface inheritance
//Employee : is the jpa entity class present in the Employee.java
//Long : data type of id column
//@Repository no need to be added hear

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
