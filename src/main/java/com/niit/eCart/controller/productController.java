package com.niit.eCart.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class productController {
	
	@RequestMapping("/")
	public String Product()
	{
		return "productlist";
	}

	}
