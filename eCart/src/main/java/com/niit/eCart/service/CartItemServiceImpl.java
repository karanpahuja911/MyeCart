package com.niit.eCart.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.niit.eCart.dao.CartItemDao;
import com.niit.eCart.model.CartItem;

	@Service
	public class CartItemServiceImpl implements CartItemService{

	    @Autowired
	    private CartItemDao cartItemDao;


		public void addCartItem(CartItem cartItem) {
			cartItemDao.addCartItem(cartItem);			
		}

		public void removeAllCartItems(int cartId) {
			cartItemDao.removeCartItem(cartId);
			
		}


		public void removeCartItem(int cartItemId) {
			cartItemDao.removeCartItem(cartItemId);
			
		}


	} 