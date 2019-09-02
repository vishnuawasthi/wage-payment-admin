package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ClientDAO;
import com.app.entities.ClientConfig;
import com.app.utils.CommonUtils;

@RestController
@RequestMapping(value = "api/v1/clients")
public class ClientConfigRestController {

	private static final Logger log = Logger.getLogger(ClientConfigRestController.class);

	@Autowired
	private ClientDAO clientDAO;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllClients() {
		List<ClientConfig> clientList = clientDAO.findAllClient();
		if (!CollectionUtils.isEmpty(clientList)) {
			return new ResponseEntity<List<ClientConfig>>(clientList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ClientConfig>>(clientList, HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getClient(@PathVariable("id") Long id) {
		ClientConfig clientConfig = clientDAO.fineClientById(id);
		if (null != clientConfig) {
			return new ResponseEntity<ClientConfig>(clientConfig, HttpStatus.OK);
		} else {
			return new ResponseEntity<ClientConfig>(clientConfig, HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object createClientConfig(@RequestBody @Valid ClientConfig clientConfig) {
		ClientConfig responseEntity = null;
		try {
			clientDAO.save(clientConfig);
		} catch (Exception e) {
			e.printStackTrace();
			List <String > errors = new ArrayList<String> ();
			errors.add(e.getMessage());
			return new ResponseEntity(	CommonUtils.buildApiErrorResponseEntity(errors, HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object updateClientConfig(@RequestBody @Valid ClientConfig clientConfig) {
		ClientConfig responseEntity = null;
		try {
			responseEntity =	clientDAO.update(clientConfig);
		} catch (Exception e) {
			e.printStackTrace();
			List <String > errors = new ArrayList<String> ();
			errors.add(e.getMessage());
			return new ResponseEntity(CommonUtils.buildApiErrorResponseEntity(errors, HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ClientConfig>(responseEntity,HttpStatus.OK);
	}

}
