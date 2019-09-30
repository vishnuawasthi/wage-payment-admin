package com.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.EmployeeDAO;
import com.app.entities.Employee;

@Controller
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value = "/search-employees", method = RequestMethod.GET)
	public ModelAndView searchEmployees(
			@RequestParam(required=false,name="id") Long id,
			@RequestParam(required=false,name="firstname")String firstname,
			@RequestParam(required=false,name="lastname") String lastname,
			@RequestParam(required=false,name="email") String email){
		 LOG .info("searchEmployees() - start");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeActive", "active");
		modelAndView.setViewName("searchEmployees");

		List<Employee> employeeList = employeeDAO.getAllEmployee(id, firstname, lastname,email);

		modelAndView.addObject("employeeList", employeeList);
		LOG .info("searchEmployees() - end");
		return modelAndView;
	}
	
	@RequestMapping(value = "/search-employees/{id}", method = RequestMethod.GET)
	public ModelAndView searchEmployees(@PathVariable("id") Long id){
		 LOG .info("searchEmployees() - start");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeActive", "active");
		modelAndView.setViewName("viewEmployeeDetails");
		Employee employee = employeeDAO.getEmployeeById(id);
		modelAndView.addObject("employee", employee);
		
		LOG .info("searchEmployees() - end");
		return modelAndView;
	}
	
	
	
	//search-employees
}
