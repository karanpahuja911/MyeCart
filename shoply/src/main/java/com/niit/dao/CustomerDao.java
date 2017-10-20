package com.niit.dao;

import com.niit.model.Customer;
import com.niit.model.User;

public interface CustomerDao {

	Customer saveOrUpdateCustomer(Customer customer);


	User validateUsername(String username);

	Customer getCustomerByUsername(String username);

	Customer validateEmail(String email);

}
