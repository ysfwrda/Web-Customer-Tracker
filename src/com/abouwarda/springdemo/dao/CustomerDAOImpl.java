package com.abouwarda.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abouwarda.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	//need to inject session factory dependency
	@Autowired
	private SessionFactory sessionFactory;
	//get the current session
	
	@Override
	@Transactional
	
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		//execute the query and get results
		List<Customer> customers = theQuery.getResultList();
		//return the results
		return customers;
	}

}
