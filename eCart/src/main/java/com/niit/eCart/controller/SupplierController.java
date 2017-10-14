package com.niit.eCart.controller;

	import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.eCart.model.Supplier;
import com.niit.eCart.service.SupplierService;


	@Controller
	public class SupplierController {

		@Autowired
		private SupplierService supplierService;
		
		@RequestMapping("/admin/supplier/supplierform")
		public String getSupplierForm(Model model){
			model.addAttribute("supplier",new Supplier());
			return "SupplierForm";
		}
		@RequestMapping("/admin/supplier/savesupplier")
		public String saveSupplier(@Valid@ModelAttribute("supplier") Supplier s,BindingResult result,HttpServletRequest request)
		{
			if(result.hasErrors())
				return "/admin/supplier/supplierform";
			supplierService.saveOrUpdateSupplier(s);
			
			return "redirect:/admin/supplier/supplierlist";
			}
		
		@RequestMapping("/admin/supplier/supplierlist")
		public String getAllSupplier(Model model){
			List<Supplier>suppliers=supplierService.getAllSuppliers();
			for(Supplier s:suppliers){	
				System.out.println(s.getSupplierName());
			}
			model.addAttribute("supplier",suppliers);
			return "supplierlist";	
		}
		
		@RequestMapping("/admin/supplier/viewsupplier/{Supplier_Id}")
		public String viewSupplier(@PathVariable int sup_Id,Model model){
			Supplier suppliers=supplierService.getSupplierBySup_Id(sup_Id);
			model.addAttribute("supplier",suppliers);
			return "viewsupplier";
		}
		
		 @RequestMapping("/admin/supplier/deletesupplier/{Supplier_Id}")
		   public String deleteSupplier(@PathVariable int sup_Id){
		   	supplierService.deleteSupplier(sup_Id);
		   	return "redirect:/admin/supplier/supplierlist";
		    }
		 
		   @RequestMapping("/admin/supplier/editsupplier/{Supplier_Id}")
		   public String editSupplier(@PathVariable int sup_Id,Model model){
		   Supplier suppliers=supplierService.getSupplierBySup_Id(sup_Id);
		   	model.addAttribute("supplier",suppliers);
		   	return "supplierform";
		   }
	}

