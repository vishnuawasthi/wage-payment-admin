package com.app.dao;

import java.util.List;

import com.app.entities.ClientConfig;
import com.app.entities.Country;
import com.app.entities.State;

public interface ClientDAO {

	Long save(ClientConfig clientConfig);
	
	ClientConfig fineClientById(Long id);
	
	ClientConfig update(ClientConfig clientConfig);
	
	List<Country> findAllCountry();
	
	List<State> findAllState();
	
	List<ClientConfig> findAllClient();
	
	List<ClientConfig> searchClientWithFilter(String searchString);
	
	List<ClientConfig> findByUniqueKey(String propertyName, String value);
	
	

}
