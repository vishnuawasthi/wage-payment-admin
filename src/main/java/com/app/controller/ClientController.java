package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.ClientDAO;
import com.app.entities.ClientConfig;
import com.app.entities.Country;
import com.app.entities.State;
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
		
		
		List<Country> countries  = clientDAO.findAllCountry();
		
		List<State> states  = clientDAO.findAllState();
		
		System.out.println("countries  : "+countries);
		System.out.println("states     : "+states);
		
		modelAndView.addObject("countries", countries);
		
		modelAndView.addObject("states", states);
		
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

		List<Country> countries  = clientDAO.findAllCountry();
		
		List<State> states  = clientDAO.findAllState();
		
		System.out.println("countries  : "+countries);
		System.out.println("states     : "+states);
		
		modelAndView.addObject("countries", countries);
		
		modelAndView.addObject("states", states);
		modelAndView.addObject("clientConfigDTO", new ClientConfig());
		return modelAndView;
	}
	// search-clients

	@RequestMapping(value = "/search-clients", method = RequestMethod.GET)
	public ModelAndView searchClients() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchClients");
		// ClientConfig clientConfig = new ClientConfig();
		// modelAndView.addObject("clientConfigDTO", clientConfig);

		List<ClientConfig> clientList = new ArrayList();

		modelAndView.addObject("clientList", getClientConfig());

		return modelAndView;
	}

	// editClient

	@RequestMapping(value = "/edit-client", method = RequestMethod.GET)
	public ModelAndView showEditClient(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editClient");
		ClientConfig clientConfig = clientDAO.fineClientById(id);
		modelAndView.addObject("clientConfigDTO", clientConfig);
		return modelAndView;
	}

	@RequestMapping(value = "/edit-client", method = RequestMethod.POST)
	public ModelAndView updateClient(@ModelAttribute("clientConfigDTO") @Valid ClientConfig clientConfig,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editClient");

		if (result.hasErrors()) {
			modelAndView.addObject("clientConfigDTO", clientConfig);
			return modelAndView;
		}

		try {
			clientDAO.update(clientConfig);
			modelAndView.addObject("status", "SUCCESS");
			modelAndView.addObject("colorValue", "aqua");
			modelAndView.addObject("feedBackMsg", "Client record updated sucessfully");
		} catch (Exception e) {
			modelAndView.addObject("status", "FAILED");
			modelAndView.addObject("colorValue", "red");
			modelAndView.addObject("feedBackMsg", e.getMessage());
			e.printStackTrace();

		}

		modelAndView.addObject("clientConfigDTO", clientConfig);
		return modelAndView;
	}

	public List<ClientConfig> getClientConfig() {
		List<ClientConfig> clientList = new ArrayList();
		ClientConfig config = new ClientConfig();
		config.setId(1234343L);
		config.setClientName("Info Pvt Ptd.");
		config.setEmail("TestEmail.com");

		clientList.add(config);

		clientList.add(config);
		clientList.add(config);
		return clientList;
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
