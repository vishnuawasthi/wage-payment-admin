package com.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public ClientConfig fineClientById(Long id) {
		ClientConfig clientConfig = sessionFactory.getCurrentSession().get(ClientConfig.class, id);
		return clientConfig;
	}

	@Override
	public ClientConfig update(ClientConfig clientConfig) {
			sessionFactory.getCurrentSession().update(clientConfig);
			return clientConfig;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public List<Country> findAllCountry() {
		return sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public List<State> findAllState() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(State.class).list();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public List<ClientConfig> findAllClient() {
		return sessionFactory.getCurrentSession().createCriteria(ClientConfig.class).list();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public List<ClientConfig> searchClientWithFilter(String searchString) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientConfig.class);

		Criterion clientName = Restrictions.ilike("clientName", searchString, MatchMode.ANYWHERE);

		Criterion clientCode = Restrictions.ilike("clientCode", searchString, MatchMode.ANYWHERE);

		Criterion registrationNumber = Restrictions.ilike("registrationNumber", searchString, MatchMode.ANYWHERE);

		criteria.add(Restrictions.or(clientName, clientCode, registrationNumber));

		return criteria.list();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public List<ClientConfig> findByUniqueKey(String propertyName, String columnValue) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientConfig.class);
		criteria.add(Restrictions.eq(propertyName, columnValue));
		return criteria.list();
	}

	
}
