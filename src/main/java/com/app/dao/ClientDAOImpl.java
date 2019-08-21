package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ClientConfig;
import com.app.entities.Country;
import com.app.entities.State;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public Long save(ClientConfig clientConfig) {
		Long id = (Long) sessionFactory.getCurrentSession().save(clientConfig);
		return id;
	}

	@Override
	public ClientConfig fineClientById(Long id) {
		ClientConfig clientConfig = sessionFactory.getCurrentSession().get(ClientConfig.class, id);
		return clientConfig;
	}

	@Override
	public void update(ClientConfig clientConfig) {
		sessionFactory.getCurrentSession().update(clientConfig);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public List<Country> findAllCountry() {
		return sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public List<State> findAllState() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(State.class).list();
	}

}
