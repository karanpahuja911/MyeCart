package com.niit.eCart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.eCart.model.Customer;
import com.niit.eCart.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/SignUp")
	public String getRegistrationForm(Model model){
		model.addAttribute("customer",new Customer());
		//model.addAttribute("customers", customerService.getCustomers());
		return "SignUp";

	}
	@ModelAttribute("customer")
	public Customer newCustomer() {
	
		return new Customer();

	}
	//we use  @modelattribute(command name) to read the values that user has entered in the jsp page.
	@RequestMapping("/all/savecustomer")
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
		/*List<Customer> customerList = customerService.getAllCustomers();
		for (int i=0; i< customerList.size(); i++){
            if(customer.getEmail().equals(customerList.get(i).getEmail())){
                model.addAttribute("emailMsg", "Email already exists");

                return "signUpForm";
            }

            if(customer.getUsername().equals(customerList.get(i).getUsername())){
                model.addAttribute("usernameMsg", "Username already exists");

                return "signUpForm";
            }
        }*/
		customerService.saveOrUpdateCustomer(customer);
		return "logInCart";
	}
	
}



