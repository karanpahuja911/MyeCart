package com.niit.eCart.dao;


import java.util.List;

import com.niit.eCart.model.Supplier;

public interface SupplierDao {

	List<Supplier> getAllSuppliers();
	
	 public Supplier getByName(String name);

	void saveOrUpdate(Supplier supplier);

	void deleteSupplier(int sup_Id);

	Supplier getSupplierBySup_Id(int sup_Id);
	
	

}
