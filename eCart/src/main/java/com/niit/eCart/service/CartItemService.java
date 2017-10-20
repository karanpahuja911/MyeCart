package com.niit.eCart.service;

import com.niit.eCart.model.Cart;
import com.niit.eCart.model.CartItem;

public interface CartItemService {

	    void addCartItem(CartItem cartItem);

	    void removeCartItem(CartItem cartItem);

	    void removeAllCartItems(Cart cart);

	    CartItem getCartItemByProductId(int productId);

	}