package com.springcrud.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.entity.Employee;
import com.springcrud.repository.EmployeeRepository;
import com.springcrud.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeRepository emprepository;

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		Employee emp = emprepository.save(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete")
	public void deleteall() {
		emprepository.deleteAll();
	}

	@GetMapping("/count")
	public ResponseEntity<Long> number(@RequestBody Employee employee) {

		long id = employeeService.getCount(employee);

		return ResponseEntity.ok(id);
	}
	
	@GetMapping("All")
	public ResponseEntity<List<Employee>> getAllEmployee(Employee employee) {
	Iterable<Employee> emp =	 employeeService.getAllEmployee(employee);
	
  List<Employee> list = StreamSupport.stream(emp.spliterator(), false).collect(Collectors.toList());
	//System.out.println(list);
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("one/{id}")
	public ResponseEntity<Employee> getbyid(@PathVariable Integer id){
		//return (ResponseEntity<Employee>) employeeService.getById(employee);
		Optional<Employee> emp = employeeService.findEmployeeById(id);
		//return ResponseEntity.ok(emp);
		System.out.println(emp);
		return new ResponseEntity<Employee>(HttpStatus.FOUND);
	}

}
