package com.niit.eCart.service;

import com.niit.eCart.model.CustomerOrder;

public interface CustomerOrderService {
	void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
