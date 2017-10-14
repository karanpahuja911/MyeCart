package com.niit.eCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.eCart.model.Cart;
import com.niit.eCart.model.Customer;
import com.niit.eCart.model.User;
import com.niit.eCart.service.CartService;
import com.niit.eCart.service.CustomerService;

@Controller
public class CartController {
    @Autowired
	private CustomerService customerService;
    @Autowired
    private CartService cartService;
    
	@RequestMapping("/cart/getCartId")
public String getCartId(Model model){
	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username=user.getUsername();
	Customer customer=customerService.getCustomerByUsername(username);
	Cart cart=customer.getCart();
	int cartId=cart.getCartId();
	model.addAttribute("cartId",cartId);
	return "cart";
}
	@RequestMapping("/cart/getCart/{cartId}")
	public @ResponseBody Cart getCart(@PathVariable int cartId){
		Cart cart=cartService.getCart(cartId);
		return cart;
	}	
}