package com.niit.eCart.dao;

import com.niit.eCart.model.Customer;
import com.niit.eCart.model.User;

public interface CustomerDao {

	Customer saveOrUpdateCustomer(Customer customer);


	User validateUsername(String username);

	Customer getCustomerByUsername(String username);

	Customer validateEmail(String email);

}