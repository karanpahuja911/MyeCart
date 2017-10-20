package com.niit.eCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.eCart.dao.CartDao;
import com.niit.eCart.model.Cart;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
private CartDao cartDao;
	public Cart getCart(int cartId) {
		return cartDao.getCart(cartId);
	}

	   public void update(Cart cart){
	        cartDao.update(cart);
	    }
}