package com.niit.eCart.dao;

import java.io.IOException;

import com.niit.eCart.model.Cart;

public interface CartDao {
	
		Cart getCart(int cartId);
		   Cart validate(int cartId) throws IOException;

		    void update(Cart cart);
}
