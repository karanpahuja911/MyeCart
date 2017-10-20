package com.niit.eCart.service;
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.eCart.dao.SupplierDao;
import com.niit.eCart.model.Supplier;
	
	@Service
	public class SupplierServiceImpl implements SupplierService {
		@Autowired
	 private SupplierDao supplierDao;
		public List<Supplier> getAllSuppliers() {
			
			return supplierDao.getAllSuppliers();
		}
		public Supplier getByName(String name) {
			
			return supplierDao.getByName(name);
		}
		public void saveOrUpdateSupplier(Supplier supplier) {
			supplierDao.saveOrUpdate(supplier);
			
		}
		public void deleteSupplier(int Supplier_Id) {
			
			supplierDao.deleteSupplier(Supplier_Id);
			
		}
		public Supplier getSupplierBySup_Id(int Supplier_Id) {
			
			return supplierDao.getSupplierBySup_Id(Supplier_Id);
		}
		
	}

