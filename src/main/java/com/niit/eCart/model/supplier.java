package com.niit.eCart.model;
	
	import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

	@Entity
	public class Supplier implements Serializable {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int SupplierId;
		private String SupplierName;

		private String SupplierContact;

		private String SupplierAddress;
	;
		
		public int getSuppliertId() {
			return SupplierId;
		}
		public int getSupplierId() {
			return SupplierId;
		}
		public void setSupplierId(int supplierId) {
			SupplierId = supplierId;
		}
		public String getSupplierName() {
			return SupplierName;
		}
		public void setSupplierName(String supplierName) {
			SupplierName = supplierName;
		}
		public String getSupplierContact() {
			return SupplierContact;
		}
		public void setSupplierContact(String supplierContact) {
			SupplierContact = supplierContact;
		}
		public String getSupplierAddress() {
			return SupplierAddress;
		}
		public void setSupplierAddress(String supplierAddress) {
			SupplierAddress = supplierAddress;
		}
	}



