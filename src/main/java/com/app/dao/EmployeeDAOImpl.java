/**
 * 
 */
package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Employee;

/**
 * @author Dell
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.app.dao.EmployeeDAO#save(com.app.entities.Employee)
	 */

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public Long save(Employee employee) {
		Long id = (Long) sessionFactory.getCurrentSession().save(employee);
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.app.dao.EmployeeDAO#update(com.app.entities.Employee)
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public Employee update(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

}
