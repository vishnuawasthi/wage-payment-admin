package com.app.dao;

import com.app.entities.Employee;

public interface EmployeeDAO {

	Long save(Employee employee);

	Employee update(Employee employee);

}
