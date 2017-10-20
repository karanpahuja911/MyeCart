package com.niit.controller;


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




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartItemController{

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/{cartId}")
    public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId){
        return cartService.getCart(cartId);
    }

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

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") int productId){
        CartItem cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);

    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId") int cartId){
        Cart cart = cartService.getCart(cartId);
        cartItemService.removeAllCartItems(cart);
    }


} // The End of Class;

