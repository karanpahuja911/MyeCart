package com.niit.eCart.service;

import com.niit.eCart.model.CartItem;

public interface CartItemService {

	    void addCartItem(CartItem cartItem);

		void removeAllCartItems(int cartId);

		void removeCartItem(int cartItemId);

		

	    

	}
