package com.niit.eCart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity

	public class product implements Serializable {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int productId;


		@NotEmpty(message = "The product name must not be empty")
		private String productName;

		private String productCategory;

		private String productDescription;

		@Min(value = 0, message = "The product price must not be less then zero")
		private double productPrice;

		private String productCondition;
		
		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductCategory() {
			return productCategory;
		}

		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}

		public String getProductDescription() {
			return productDescription;
		}

		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public double getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}

		public String getProductCondition() {
			return productCondition;
		}

		public void setProductCondition(String productCondition) {
			this.productCondition = productCondition;
		
	}
		}
