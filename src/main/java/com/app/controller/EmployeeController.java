package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.EmployeeDAO;
import com.app.entities.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value = "/search-employees", method = RequestMethod.GET)
	public ModelAndView searchEmployees() {
		System.out.println("searchEmployees() - start");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeActive", "active");
		modelAndView.setViewName("searchEmployees");

		List<Employee> employeeList = employeeDAO.getAllEmployee();

		modelAndView.addObject("employeeList", employeeList);
		System.out.println("searchEmployees() - end");
		return modelAndView;
	}
	
	//search-employees
}
