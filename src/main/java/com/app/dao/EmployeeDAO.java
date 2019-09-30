package com.app.dao;

import java.util.List;

import com.app.entities.Employee;
import com.app.entities.EmployeePayments;
import com.app.entities.Payment;

public interface EmployeeDAO {

	Long save(Employee employee);

	Employee update(Employee employee);

	List<Employee> getAllEmployee(Long id, String firstname, String lastname, String email);

	Employee getEmployeeById(Long id);

	Long fundEmployee(Payment payment);
	
	List<EmployeePayments> getAllEmployeePayments();

}
