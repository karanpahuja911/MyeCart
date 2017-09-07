package com.niit.eCart.model;
	
	import java.io.Serializable;

	public class supplier implements Serializable {
		
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



