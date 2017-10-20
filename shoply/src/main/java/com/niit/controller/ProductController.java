package com.niit.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Product;
import com.niit.service.ProductService;
@Controller	
public class ProductController {
	@Autowired	
	private ProductService productservice;
	
	private Path path;
	
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
	       
	       MultipartFile productImage = product.getImage();
	        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".jpg");
	        System.out.println("path" +path);
	        if(productImage != null && !productImage.isEmpty()){
	            try {
	                productImage.transferTo(new File(path.toString()));
	            } catch (Exception ex){
	                ex.printStackTrace();
	                throw new RuntimeException("Product image saving failed", ex);
	            }
	        }

	       
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


	@RequestMapping("/editform/{productId}")
	public String editProductForm(@PathVariable int productId, Model model) {
		model.addAttribute("product1", productservice.getProductById(productId));
		System.out.println("Product id:" +productId);
	
		return "editProduct";
	}

	
	
@RequestMapping("/editProduct/{productId}")
public String editProduct(@ModelAttribute(value="product1") Product product, HttpServletRequest request) {
	System.out.println("inside saveProduct");
	  MultipartFile productImage = product.getImage();
      String rootDirectory = request.getSession().getServletContext().getRealPath("/");
      path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".jpg");
      System.out.println("path" +path);
      if(productImage != null && !productImage.isEmpty()){
          try {
              productImage.transferTo(new File(path.toString()));
          } catch (Exception ex){
              ex.printStackTrace();
              throw new RuntimeException("Product image saving failed", ex);
          }
      }

	productservice.editProduct(product);
	
	return "redirect:/getAllProduct";
	
	}

@RequestMapping("/admin/product/deleteproduct/{productId}")
public String deleteProduct(@PathVariable int productId, Model model){
	productservice.deleteProduct(productId);
	return "redirect:/getAllProduct";
}

}
