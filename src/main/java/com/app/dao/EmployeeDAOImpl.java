/**
 * 
 */
package com.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.app.entities.Employee;
import com.app.entities.EmployeePayments;
import com.app.entities.Payment;

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

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public List<Employee> getAllEmployee(Long id, String firstname, String lastname, String email) {
		// List<Employee> employeeList =
		// sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		Criterion firstnameCriterion = null;
		Criterion lastCriterion = null;
		Criterion emailCriterion = null;
		Criterion idCriterion = null;

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);

		if (!StringUtils.isEmpty(firstname)) {
			firstnameCriterion = Restrictions.ilike("firstname", firstname, MatchMode.ANYWHERE);
		}

		if (!StringUtils.isEmpty(lastname)) {
			lastCriterion = Restrictions.ilike("lastname", firstname, MatchMode.ANYWHERE);
		}

		if (!StringUtils.isEmpty(email)) {
			emailCriterion = Restrictions.ilike("email", email, MatchMode.ANYWHERE);
		}

		if (!StringUtils.isEmpty(id)) {
			idCriterion = Restrictions.eq("id", id);
		}

		if (!StringUtils.isEmpty(idCriterion)) {
			criteria.add(idCriterion);
		}
		Disjunction disjunctions = Restrictions.disjunction();

		if (null != firstnameCriterion) {
			disjunctions.add(firstnameCriterion);
		}

		if (null != lastCriterion) {
			disjunctions.add(lastCriterion);
		}

		if (null != emailCriterion) {
			disjunctions.add(emailCriterion);
		}

		criteria.add(disjunctions);

		return criteria.list();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee = sessionFactory.getCurrentSession().get(Employee.class, id);
		return employee;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public Long fundEmployee(Payment payment) {
		Long id = (Long) sessionFactory.getCurrentSession().save(payment);
		return id;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public List<EmployeePayments> getAllEmployeePayments() {
		List<EmployeePayments> employeePayments = sessionFactory.getCurrentSession().createCriteria(EmployeePayments.class).list();
		return employeePayments;
	}

}
