package com.niit.eCart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.eCart.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{
@Autowired	
private SessionFactory sessionFactory;
	public Cart getCart(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class, cartId);
		session.close();
		return cart;
	}

	
	
}
