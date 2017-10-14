
package com.niit.eCart.service;



	import java.util.List;

import com.niit.eCart.model.Supplier;

	public interface SupplierService {
	
		void saveOrUpdateSupplier(Supplier supplier);
		
		List<Supplier> getAllSuppliers();
		
		public Supplier getByName(String name);

		void deleteSupplier(int sup_Id);

		Supplier getSupplierBySup_Id(int sup_Id);
		


	}

