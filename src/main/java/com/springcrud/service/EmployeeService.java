package com.springcrud.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springcrud.entity.Employee;
import com.springcrud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeerepository;
	
	public Employee save(com.springcrud.entity.Employee employee)   
	{  
		return 	employeerepository.save(employee);
	
	}  
	
	public void delete(Employee employee) {
		 employeerepository.deleteAll();
		
	}
	
	public long getEmployee(Employee employee) {
		return employeerepository.count();
	}

	public long getCount(Employee employee) {
		
	long emp =	employeerepository.count();
		return emp;
	}

	public Iterable<Employee> getAllEmployee(Employee employee) {
		 Iterable<Employee> emp =  employeerepository.findAll();
		return emp;
	}

	/*
	 * // public Iterable<Employee> getById(Employee employee) { //
	 * Iterable<Employee> emp=(Iterable<Employee>)
	 * employeerepository.getById(employee); // return emp; // }
	 */
	public Optional<Employee> findEmployeeById(Integer id) {
	 Optional<Employee> emp =	employeerepository.findById(id);
		return emp;
	}
	
}
