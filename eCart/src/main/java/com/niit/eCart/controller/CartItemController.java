package com.niit.eCart.controller;
/*
	import java.util.List; 

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.context.SecurityContextHolder;
	import org.springframework.security.core.userdetails.User;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;

import com.niit.eCart.model.Cart;
import com.niit.eCart.model.CartItem;
import com.niit.eCart.model.Customer;
import com.niit.eCart.model.Product;
import com.niit.eCart.service.CartItemService;
import com.niit.eCart.service.CustomerService;
import com.niit.eCart.service.ProductService;


	@Controller
	public class CartItemController {

		@Autowired
		private ProductService productService;
		
		@Autowired
		private CustomerService customerService;
		
		@Autowired
		private CartItemService cartItemService;
		
		
		@RequestMapping("/cart/addtocart/{pid}")
		public String addCartItem(@PathVariable int pid,@RequestParam int units,@RequestParam(value="error", required = false)
		String error,Model model){
			Product product=productService.getProductById(pid);
			System.out.println("units" +units);
			System.out.println("quantity" +product.getProductQuantity());
			
			if(units<=product.getProductQuantity()){
			User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username=user.getUsername();
			Customer customer=customerService.getCustomerByUsername(username);
			Cart cart=customer.getCart();
			List<CartItem> cartItems=cart.getCartItems();
			System.out.println(cart.getCartItems().size());
		
		for(CartItem cartItem:cartItems){
			
			System.out.println(cartItem.getProduct().getProductId());
			System.out.println(pid);
			if(cartItem.getProduct().getProductId()==pid){
				cartItem.setQuantity(units);
				cartItem.setTotalPrice(product.getProductPrice()*units);
				cartItemService.addCartItem(cartItem);
			return "redirect:/cart/getcart";
			}
		}
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(units);
		cartItem.setTotalPrice(product.getProductPrice()* units);
		cartItem.setProduct(product);
		 cartItem.setCart(cart);
		 cartItemService.addCartItem(cartItem);
		 return "redirect:/cart/getcart";
		 }
			else{
				if(error != null){
					model.addAttribute("error", "Out of Stock");
					}
				
				return "redirect:/all/product/viewproduct/{pid}";
			}
		}
		
		@RequestMapping("cart/getcart")
		public String getCart(Model model){
			User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=user.getUsername();
		Customer customer=customerService.getCustomerByUsername(username);
		Cart cart=customer.getCart();
		model.addAttribute("cart",cart);
		return "cart";
		}
		
		@RequestMapping("/cart/removecartitem/{cartItemId}")
		public String removeCartItem(@PathVariable int cartItemId){
			cartItemService.removeCartItem(cartItemId);
			return "redirect:/cart/getcart";
			
		}
		
		@RequestMapping("/cart/clearcart/{cartId}")
		public String removeAllCartItem(@PathVariable("cartId") int cartId){
			cartItemService.removeAllCartItems(cartId);
			return "redirect:/cart/getcart";
			
		}
	}


	
	
/*	package com.musichub.controller;

	import com.musichub.model.Cart;
	import com.musichub.model.CartItem;
	import com.musichub.model.Customer;
	import com.musichub.model.Product;
	import com.musichub.service.CartItemService;
	import com.musichub.service.CartService;
	import com.musichub.service.CustomerService;
	import com.musichub.service.ProductService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.security.core.userdetails.User;
	import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@Controller
	@RequestMapping("/rest/cart")
	public class CartResources {

	    @Autowired
	    private CartService cartService;

	    @Autowired
	    private CartItemService cartItemService;

	    @Autowired
	    private CustomerService customerService;

	    @Autowired
	    private ProductService productService;

	  

	    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void addItem (@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser){
	        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
	        Cart cart = customer.getCart();
	        Product product = productService.getProductById(productId);
	        List<CartItem> cartItems = cart.getCartItems();

	        for (int i=0; i < cartItems.size(); i++){
	            if(product.getProductId() == cartItems.get(i).getProduct().getProductId()){
	                CartItem cartItem = cartItems.get(i);
	                cartItem.setQuantity(cartItem.getQuantity() + 1);
	                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
	                cartItemService.addCartItem(cartItem);

	                return;
	            }
	        }

	        CartItem cartItem = new CartItem();
	        cartItem.setProduct(product);
	        cartItem.setQuantity(1);
	        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
	        cartItem.setCart(cart);
	        cartItemService.addCartItem(cartItem);
	    }

	  


	} // The End of Class;
*/




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.niit.eCart.model.Cart;
import com.niit.eCart.model.CartItem;
import com.niit.eCart.model.Customer;
import com.niit.eCart.model.Product;
import com.niit.eCart.service.CartItemService;
import com.niit.eCart.service.CustomerService;
import com.niit.eCart.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/customer/rest/cart")
public class CartItemController{

    @Autowired
    private CartItemService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

  

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "productId") int productId){
    	User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = customerService.getCustomerByUsername(user.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i=0; i < cartItems.size(); i++){
            if(product.getProductId() == cartItems.get(i).getProduct().getProductId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }
        

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

  


} // The End of Class;

