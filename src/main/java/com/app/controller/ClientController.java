package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
import com.app.utils.ClientType;
import com.app.utils.CommonUtils;

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
		setCommonDetailsForClient(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/client-config", method = RequestMethod.POST)
	public ModelAndView saveClientConfig(@ModelAttribute("clientConfigDTO") @Valid ClientConfig clientConfig,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("clientConfig");

		setCommonDetailsForClient(modelAndView);

		if (result.hasErrors()) {
			modelAndView.addObject("clientConfigDTO", clientConfig);
			return modelAndView;
		}
		// ClientConfig clientConfig = new ClientConfig();

		System.out.println("clientConfig {}  " + clientConfig);

		try {

			if (!StringUtils.isEmpty(clientConfig.getOnboardDateTxt())) {
				clientConfig.setOnboardDate(CommonUtils.convertStringToDate(clientConfig.getOnboardDateTxt(), "yyyy-MM-dd"));
			}
			if (!StringUtils.isEmpty(clientConfig.getLiveDateTxt())) {
				clientConfig.setLiveDate(CommonUtils.convertStringToDate(clientConfig.getLiveDateTxt(), "yyyy-MM-dd"));
			}

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
			modelAndView.addObject("clientConfigDTO", clientConfig);
			return modelAndView;
		}

		modelAndView.addObject("clientConfigDTO", new ClientConfig());
		return modelAndView;
	}
	// search-clients

	@RequestMapping(value = "/search-clients", method = RequestMethod.GET)
	public ModelAndView searchClients(@RequestParam(name = "searchKeyWord", required = false) String searchKeyWord) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchClients");
		// ClientConfig clientConfig = new ClientConfig();
		// modelAndView.addObject("clientConfigDTO", clientConfig);

		System.out.println("searchKeyWord  : " + searchKeyWord);
		List<ClientConfig> clientList = null;

		if (StringUtils.isEmpty(searchKeyWord)) {
			clientList = clientDAO.findAllClient();
		} else {
			clientList = clientDAO.searchClientWithFilter(searchKeyWord);
		}

		modelAndView.addObject("clientList", clientList);

		return modelAndView;
	}

	// editClient

	@RequestMapping(value = "/edit-client", method = RequestMethod.GET)
	public ModelAndView showEditClient(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editClient");
		setCommonDetailsForClient(modelAndView);
		ClientConfig clientConfig = clientDAO.fineClientById(id);
		clientConfig.setStateCode(null);
		modelAndView.addObject("clientConfigDTO", clientConfig);
		return modelAndView;
	}

	@RequestMapping(value = "/edit-client", method = RequestMethod.POST)
	public ModelAndView updateClient(@ModelAttribute("clientConfigDTO") @Valid ClientConfig clientConfig,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editClient");

		setCommonDetailsForClient(modelAndView);
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
		config.setId(123434L);
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

	private List<ClientType> getClientType() {
		List<ClientType> clientTypes = new ArrayList<ClientType>();

		ClientType standAlone = new ClientType("Stand alone client", "SA");
		ClientType multiFeature = new ClientType("Multi Feature client", "MF");

		clientTypes.add(standAlone);
		clientTypes.add(multiFeature);
		return clientTypes;

	}

	private void setCommonDetailsForClient(ModelAndView modelAndView) {
		List<Country> countries = clientDAO.findAllCountry();
		List<State> states = clientDAO.findAllState();
		System.out.println("countries  : " + countries);
		System.out.println("states     : " + states);
		modelAndView.addObject("countries", countries);
		modelAndView.addObject("states", states);

		List<ClientType> clientTypes = getClientType();
		modelAndView.addObject("clientTypes", clientTypes);
	}
}
