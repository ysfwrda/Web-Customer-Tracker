package com.abouwarda.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abouwarda.springdemo.dao.CustomerDAO;
import com.abouwarda.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	//need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(theCustomer);
	}
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theId);
	}
	

}
