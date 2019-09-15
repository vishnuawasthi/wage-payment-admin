package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.ClientDAO;
import com.app.dao.EmployeeDAO;
import com.app.dto.ClientConfigDTO;
import com.app.entities.ClientConfig;
import com.app.entities.Country;
import com.app.entities.Employee;
import com.app.entities.State;
import com.app.entities.TestForm;
import com.app.utils.ClientType;
import com.app.utils.CommonUtils;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Controller
public class ClientController {

	@Autowired
	private ClientDAO clientDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public ModelAndView showIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("indexPage");
		return modelAndView;
	}

	@RequestMapping(value = "/client-config", method = RequestMethod.GET)
	public ModelAndView clientConfig() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("clientConfigActive", "active");
		modelAndView.setViewName("clientConfig");
		ClientConfig clientConfig = new ClientConfig();
		modelAndView.addObject("clientConfigDTO", clientConfig);
		setCommonDetailsForClient(modelAndView);
		modelAndView.addObject("clientConfigActive", "active");
		return modelAndView;
	}

	@RequestMapping(value = "/client-config", method = RequestMethod.POST)
	public ModelAndView saveClientConfig(@ModelAttribute("clientConfigDTO") @Valid ClientConfig clientConfig,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("clientConfig");
		modelAndView.addObject("clientConfigActive", "active");
		setCommonDetailsForClient(modelAndView);

		if (result.hasErrors()) {
			modelAndView.addObject("clientConfigDTO", clientConfig);
			return modelAndView;
		}
		// ClientConfig clientConfig = new ClientConfig();

		System.out.println("clientConfig {}  " + clientConfig);

		try {

			if (!StringUtils.isEmpty(clientConfig.getOnboardDateTxt())) {
				clientConfig.setOnboardDate(
						CommonUtils.convertStringToDate(clientConfig.getOnboardDateTxt(), "yyyy-MM-dd"));
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
		modelAndView.addObject("clientConfigActive", "active");
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
		modelAndView.addObject("clientConfigActive", "active");
		modelAndView.setViewName("editClient");
		setCommonDetailsForClient(modelAndView);
		ClientConfig clientConfig = clientDAO.fineClientById(id);
		clientConfig.setStateCode(null);
		ClientConfigDTO clientConfigDTO  = new ClientConfigDTO();
		CommonUtils.populateClientConfigDTO(clientConfig,clientConfigDTO);
		modelAndView.addObject("clientConfigDTO", clientConfigDTO);
		modelAndView.addObject("clientConfigActive", "active");
		return modelAndView;
	}

	@RequestMapping(value = "/edit-client", method = RequestMethod.POST)
	public ModelAndView updateClient(@ModelAttribute("clientConfigDTO") @Valid ClientConfigDTO clientConfigDTO,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("clientConfigActive", "active");
		modelAndView.setViewName("editClient");
		setCommonDetailsForClient(modelAndView);
		
		if (result.hasErrors()) {
			modelAndView.addObject("clientConfigDTO", clientConfigDTO);
			return modelAndView;
		}

		try {
			ClientConfig clientConfig = clientDAO.fineClientById(clientConfigDTO.getId());
			CommonUtils.populateClientConfig(clientConfig, clientConfigDTO);
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
		modelAndView.addObject("clientConfigDTO", clientConfigDTO);
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

		List<ClientConfig> clientConfigList = clientDAO.findAllClient();
		
		modelAndView.addObject("clientConfigList", clientConfigList);
		
		List<ClientType> clientTypes = getClientType();
		modelAndView.addObject("clientTypes", clientTypes);
	}

	@RequestMapping(value = "/export-clients", method = RequestMethod.GET)
	public void downloadClietCsvFile(HttpServletRequest request, HttpServletResponse response) {
		// set file name and content type
		String filename = "clients.csv";

		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

		// create a csv writer
		StatefulBeanToCsv<ClientConfig> writer;
		try {
			writer = new StatefulBeanToCsvBuilder<ClientConfig>(response.getWriter())
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
					.withOrderedResults(false).build();

			List list = clientDAO.findAllClient();
			writer.write(list);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// write all users to csv file
		catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView showEmployee() {
		System.out.println("showEmployee() - start");
		//employeeActive
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeActive", "active");
		setCommonDetailsForClient( modelAndView);
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("addEmployee");
		System.out.println("showEmployee() - end");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {
		System.out.println("saveEmployee() - start");
		ModelAndView modelAndView = new ModelAndView();
		//employeeActive
		modelAndView.addObject("employeeActive", "active");
		modelAndView.setViewName("addEmployee");
		setCommonDetailsForClient( modelAndView);
		
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}

		try {
			employee.setCreatedDate(new Date());
			employee.setUpdatedDate(new Date());
			
			ClientConfig clientConfig = clientDAO.findClientByCode(employee.getClientCode());
			
			employee.setClientConfig(clientConfig);
			Long id = employeeDAO.save(employee);
			
			modelAndView.addObject("status", "SUCCESS");
			modelAndView.addObject("colorValue", "aqua");
			modelAndView.addObject("feedBackMsg", "Record Saved Successfully! ID  " + id);
		} catch (Exception e) {
			modelAndView.addObject("status", "FAILED");
			modelAndView.addObject("colorValue", "red");
			modelAndView.addObject("feedBackMsg", e.getMessage());
			e.printStackTrace();
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}
		modelAndView.addObject("employee", new Employee());
		System.out.println("saveEmployee() - end");
		return modelAndView;
	}
	
	
	
	
	@RequestMapping(value = "/home-page", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("home() - start");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("homeActive", "active");
		modelAndView.setViewName("home");
		System.out.println("home() - end");
		return modelAndView;
	}

}
