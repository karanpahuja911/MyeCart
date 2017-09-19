package com.niit.eCart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.eCart.model.Category;
import com.niit.eCart.service.ProductService;


@Controller
public class CategoryController {
	@Autowired
	ProductService ps;
	
	@RequestMapping("/admin/getcategory")
	public String getCategoryForm(Model model){

		model.addAttribute("categories",new Category());
		
		return "Category";
	}

	@RequestMapping("/all/product/searchbycategory")
	public String selectByCategory(@RequestParam String searchCondition,Model model){
		model.addAttribute("product", ps.getAllProduct());
		if(searchCondition.equals("All"))
			model.addAttribute("searchCondition","");
		else
			model.addAttribute("searchCondition", searchCondition);
		return "productlist";
	
	}
}