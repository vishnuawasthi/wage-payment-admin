package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.ClientDAO;
import com.app.entities.ClientConfig;
import com.app.entities.TestForm;

@Controller
public class ClientController {

	@Autowired
	private ClientDAO clientDAO;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public ModelAndView showIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("indexPage");
		return modelAndView;
	}

	@RequestMapping(value = "/client-config", method = RequestMethod.GET)
	public ModelAndView clientConfig() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("clientConfig");
		ClientConfig clientConfig = new ClientConfig();

		modelAndView.addObject("clientConfigDTO", clientConfig);
		return modelAndView;
	}

	@RequestMapping(value = "/client-config", method = RequestMethod.POST)
	public ModelAndView saveClientConfig(@ModelAttribute("clientConfigDTO") @Valid ClientConfig clientConfig,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("clientConfig");

		if (result.hasErrors()) {
			modelAndView.addObject("clientConfigDTO", clientConfig);
			return modelAndView;

		}
		// ClientConfig clientConfig = new ClientConfig();

		System.out.println("clientConfig {}  " + clientConfig);

		try {

			Long id = clientDAO.save(clientConfig);
			if (id != null) {
				modelAndView.addObject("status", "SUCCESS");
				modelAndView.addObject("colorValue", "aqua");
				modelAndView.addObject("feedBackMsg", "Record Saved Successfully! ID  " + id);
			} else {
				modelAndView.addObject("status", "FAILED");
				modelAndView.addObject("colorValue", "red");
				modelAndView.addObject("feedBackMsg", "Unable to save record");
			}
		} catch (Exception e) {
			modelAndView.addObject("status", "FAILED");
			modelAndView.addObject("colorValue", "red");
			modelAndView.addObject("feedBackMsg", e.getMessage());
		}

		modelAndView.addObject("clientConfigDTO", new ClientConfig());
		return modelAndView;
	}

	@RequestMapping(value = "/testValidation", method = RequestMethod.GET)
	public ModelAndView showTestForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("testJsp");
		TestForm testForm = new TestForm();

		modelAndView.addObject("testForm", testForm);
		return modelAndView;
	}
	// testForm

	@RequestMapping(value = "/testValidation", method = RequestMethod.POST)
	public ModelAndView saveTestForm(@ModelAttribute("testForm") @Valid TestForm testForm, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("testJsp");

		if (result.hasErrors()) {
			modelAndView.addObject("testForm", testForm);
			return modelAndView;
		}
		// ClientConfig clientConfig = new ClientConfig();
		System.out.println("clientConfig {}  " + testForm);
		modelAndView.addObject("testForm", new TestForm());
		return modelAndView;
	}
}
