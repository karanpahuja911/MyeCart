package com.niit.eCart.service;

import com.niit.eCart.model.Cart;
import com.niit.eCart.model.CustomerOrder;

public interface CustomerOrderService {
	CustomerOrder createOrder(Cart cart);
	}
