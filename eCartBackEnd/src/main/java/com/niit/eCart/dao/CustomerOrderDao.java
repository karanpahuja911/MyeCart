package com.niit.eCart.dao;

import com.niit.eCart.model.Cart;
import com.niit.eCart.model.CustomerOrder;

public interface CustomerOrderDao {
	CustomerOrder createOrder(Cart cart);

	}
	