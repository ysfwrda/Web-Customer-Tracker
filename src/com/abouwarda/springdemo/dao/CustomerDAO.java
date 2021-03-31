package com.abouwarda.springdemo.dao;

import java.util.List;

import com.abouwarda.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
}
