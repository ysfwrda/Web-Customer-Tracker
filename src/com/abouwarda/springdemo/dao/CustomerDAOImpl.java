package com.abouwarda.springdemo.dao;

import com.abouwarda.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		//execute the query and get results
		List<Customer> customers = theQuery.getResultList();
		//return the results
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// 	get the current Hibernate session
		Session actual = sessionFactory.getCurrentSession();
		// save the customer to the database
		actual.saveOrUpdate(theCustomer);
		//
		
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		//get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//retrieve the customer from the database using the Primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}
	
}
