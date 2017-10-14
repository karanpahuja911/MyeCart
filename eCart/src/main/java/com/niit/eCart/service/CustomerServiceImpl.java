package com.niit.eCart.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.eCart.dao.CustomerDao;
import com.niit.eCart.model.Cart;
import com.niit.eCart.model.Customer;
import com.niit.eCart.model.CustomerOrder;
import com.niit.eCart.model.User;
	
	@Service
	@Transactional
	public class CustomerServiceImpl implements CustomerService{

		@Autowired
		private CustomerDao customerDao;
		
	
		public User validateUsername(String username) {
			
			return customerDao.validateUsername(username);
		}
		
		
		public Customer validateEmail(String email) {
			
			return customerDao.validateEmail(email);
		}
		
		public Customer getCustomerByUsername(String username) {
			
			return customerDao.getCustomerByUsername(username);
		}

		public Customer saveOrUpdateCustomer(Customer customer) {
			return customerDao.saveOrUpdateCustomer(customer);
		}

		

	}