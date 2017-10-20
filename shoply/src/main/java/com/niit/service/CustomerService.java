package com.niit.service;

import com.niit.model.Customer;
import com.niit.model.User;

public interface CustomerService {

	Customer saveOrUpdateCustomer(Customer customer);		
		User validateUsername(String username);
	    Customer validateEmail(String email);
		Customer getCustomerByUsername(String username);
	}
