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
import com.app.dto.ClientConfigDTO;
import com.app.entities.ClientConfig;
import com.app.utils.CommonUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "api/v1/clients")
public class ClientConfigRestController {

	private static final Logger log = Logger.getLogger(ClientConfigRestController.class);

	
	@Autowired
	private ClientDAO clientDAO;

	@ApiOperation(value = "Get list of all the Clients", httpMethod="GET",
			tags="ClientConfig")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllClients() {
		
		List<ClientConfig> clientList = clientDAO.findAllClient();
		
		if (CollectionUtils.isEmpty(clientList)) {
			return new ResponseEntity<List<ClientConfig>>(clientList, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ClientConfig>>(clientList,HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Get client by id", response = Iterable.class,httpMethod="GET",
			tags="ClientConfig")
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code =500, message = "Server has incountered problem while retriving resource")
	}
	)
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getClient(@PathVariable("id") Long id) {
		ClientConfig clientConfig = clientDAO.fineClientById(id);
		if (null != clientConfig) {
			return new ResponseEntity<ClientConfig>(clientConfig, HttpStatus.OK);
		} else {
			return new ResponseEntity<ClientConfig>(clientConfig, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Create clients", response = Iterable.class,httpMethod="POST",
			tags="ClientConfig")
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
	
	@ApiOperation(value = "Update clients", response = Iterable.class,httpMethod="PUT",
			tags="ClientConfig")
	@RequestMapping(method = RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object updateClientConfig(@RequestBody @Valid ClientConfigDTO clientConfigDTO) {
		ClientConfig clientConfig = null;
		try {
			//responseEntity =	clientDAO.update(clientConfig);
			clientConfig =  clientDAO.fineClientById(clientConfigDTO.getId());
			CommonUtils.populateClientConfig(clientConfig,clientConfigDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
			List <String > errors = new ArrayList<String> ();
			errors.add(e.getMessage());
			return new ResponseEntity(CommonUtils.buildApiErrorResponseEntity(errors, HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ClientConfig>(clientConfig,HttpStatus.OK);
	}
	
	

}
