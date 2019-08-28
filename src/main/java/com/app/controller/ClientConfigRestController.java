package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ClientDAO;
import com.app.entities.ClientConfig;

@RestController
@RequestMapping(value = "api/v1/clients")
public class ClientConfigRestController {

	private static final Logger log = Logger.getLogger(ClientConfigRestController.class);

	
	@Autowired
	private ClientDAO clientDAO;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllClients() {

		List<ClientConfig> clientList = clientDAO.findAllClient();

		return new ResponseEntity<List<ClientConfig>>(clientList, HttpStatus.OK);
	}

}
