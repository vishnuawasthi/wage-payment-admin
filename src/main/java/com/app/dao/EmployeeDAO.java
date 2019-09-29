package com.app.dao;

import java.util.List;

import com.app.entities.Employee;

public interface EmployeeDAO {

	Long save(Employee employee);

	Employee update(Employee employee);
	
	List<Employee> getAllEmployee ();

}
