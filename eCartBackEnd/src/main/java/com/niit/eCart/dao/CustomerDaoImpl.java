package com.niit.eCart.dao;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.eCart.model.Authority;
import com.niit.eCart.model.BillingAddress;
import com.niit.eCart.model.Cart;
import com.niit.eCart.model.Customer;
import com.niit.eCart.model.ShippingAddress;
import com.niit.eCart.model.User;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Customer saveOrUpdateCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		// child tables - Users, billingAddress, ShippingAddress
		BillingAddress billingAddress = customer.getBillingAddress();
		ShippingAddress shippingAddress = customer.getShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		billingAddress.setCustomer(customer);
		shippingAddress.setCustomer(customer);
	

		User users = new User();
		users.setUserId(customer.getId());
		users.setUsername(customer.getUsername());
		customer.getUsers();
		customer.setUsers(users);
		
		
		

		users.setEnabled(true);
		users.setPassword(customer.getPassword());

		Authority authority = new Authority();
		authority.setRole("ROLE_USER");
		authority.setUsername(customer.getUsername());

		Cart cart = new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		
		session.saveOrUpdate(cart);
		session.saveOrUpdate(billingAddress);
		session.saveOrUpdate(shippingAddress);
		session.saveOrUpdate(users);
		session.saveOrUpdate(authority);
		session.saveOrUpdate(customer);// insert into customer values (.....)
	
		session.flush();
		session.close();
		System.out.println(customer.getId());
		return customer;
	}

	

	public User validateUsername(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where username=?");
		query.setString(0, username);
		User user=(User)query.uniqueResult();
		return user;
	}

	public Customer getCustomerByUsername(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer where username=?");
		query.setString(0,username);
		Customer customer=(Customer)query.uniqueResult();
		return customer;
	}

	public Customer validateEmail(String email) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer where email=?");
		query.setString(0, email);
		Customer customer=(Customer)query.uniqueResult();
		return customer;
	}

}
