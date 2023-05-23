package com.springcrud.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springcrud.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {


   // @Query("sel")
	//Employee findById();

	Employee getById(Employee employee);

}
