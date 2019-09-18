package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.ClientDAO;
import com.app.dao.EmployeeDAO;

@Controller
public class PaymentController {

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping(value = "/payments", method = RequestMethod.GET)
	public ModelAndView doPayment() {
		System.out.println("funding() - start");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("funding");
		System.out.println("funding() - end");
		return modelAndView;
	}
}
