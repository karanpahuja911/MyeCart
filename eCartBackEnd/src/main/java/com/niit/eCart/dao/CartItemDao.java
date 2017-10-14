package com.niit.eCart.dao;

import com.niit.eCart.model.CartItem;

public interface CartItemDao {

	    void addCartItem(CartItem cartItem);

		void removeCartItem(int cartId);

	 
	}
