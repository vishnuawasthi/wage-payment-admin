package com.app.dao;

import java.util.List;

import com.app.entities.ClientConfig;
import com.app.entities.Country;
import com.app.entities.State;

public interface ClientDAO {

	Long save(ClientConfig clientConfig);
	
	ClientConfig fineClientById(Long id);
	
	void update(ClientConfig clientConfig);
	
	List<Country> findAllCountry();
	
	List<State> findAllState();
	

}
