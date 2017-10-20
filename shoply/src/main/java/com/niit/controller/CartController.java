/*package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.User;
import com.niit.service.CartService;
import com.niit.service.CustomerService;

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
}*/

package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Customer;
import com.niit.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(){
    	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username=user.getUsername();
    	Customer customer=customerService.getCustomerByUsername(username);
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
        model.addAttribute("cartId", cartId);

        return "Cart";
    }

}