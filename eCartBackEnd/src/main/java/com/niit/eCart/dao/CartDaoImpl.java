package com.niit.eCart.dao;

import java.io.IOException;

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

/*@Autowired
private CustomerOrderService customerOrderService;*/

public Cart getCart(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class, cartId);
		session.close();
		return cart;
	}
	 public void update(Cart cart){
	        int cartId = cart.getCartId();
	        double grandTotal = 95;//customerOrderService.getCustomerOrderGrandTotal(cartId);
	        cart.setGrandTotal(grandTotal);

	        Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(cart);
	    }

	    public Cart validate(int cartId) throws IOException{
	        Cart cart = getCart(cartId);
	        if(cart == null || cart.getCartItems().size() == 0){
	            throw new IOException(cartId + "");
	        }

	        update(cart);
	        return cart;
	    }

	
	
}
