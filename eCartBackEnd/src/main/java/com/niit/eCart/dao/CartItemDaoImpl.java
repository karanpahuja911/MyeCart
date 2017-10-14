package com.niit.eCart.dao;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.eCart.model.CartItem;

import java.util.List;

	@Repository
	@Transactional
	public class CartItemDaoImpl implements CartItemDao{

	    @Autowired
	    private SessionFactory sessionFactory;

	   
		public void addCartItem(CartItem cartItem) {
			 Session session = sessionFactory.getCurrentSession();
		        session.saveOrUpdate(cartItem);
		        session.flush();
			
		}


		public void removeCartItem(int cartItemId) {
			 Session session = sessionFactory.getCurrentSession();
		        session.saveOrUpdate(cartItemId);
		        session.flush();
						
		}

	   

	} 
