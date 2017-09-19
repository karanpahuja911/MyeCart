package com.niit.eCart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.eCart.model.Product;
import com.niit.eCart.service.ProductService;
@Controller	
public class ProductController {
	@Autowired	
	private ProductService productservice;
	
	@RequestMapping("/saveProduct")
	public String addProduct(Model model) {
		Product product=new Product();
		model.addAttribute("product", product);
		
		return "ProductForm";
		
	}
	
	   @RequestMapping(value="/admin/product/addNewProduct", method = RequestMethod.POST)
	    public String addProductPost(@ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){

	        if(result.hasErrors()){
	            return "ProductForm";
	        }
	        
	       productservice.addProduct(product);
	        return "redirect:/getAllProduct";
	    }
	
	@RequestMapping("/getAllProduct")
	public String getAllProduct(Model model)
	{
	List<Product> allproduct= productservice.getAllProduct();
	model.addAttribute("product",allproduct);
	return "ProductList";
	}
	
	
	@RequestMapping("/all/product/viewproduct/{productId}")
	public String viewProduct(@PathVariable int productId,Model model){
		Product product=productservice.getProductById(productId);
		model.addAttribute("pd",product);
	return "ViewProduct";
	}

}

