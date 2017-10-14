package com.niit.eCart.service;

import com.niit.eCart.model.Customer;
import com.niit.eCart.model.User;

public interface CustomerService {

	Customer saveOrUpdateCustomer(Customer customer);		
		User validateUsername(String username);
	    Customer validateEmail(String email);
		Customer getCustomerByUsername(String username);
	}
