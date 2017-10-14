package com.niit.eCart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product implements Serializable {
		
	@Transient 
	private MultipartFile image;
	public MultipartFile getImage() 
	{ 
		return image; 
		} 
	public void setImage(MultipartFile image) 
	{ 
		this.image = image; 
	}
	
	@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int productId;

		private String productName;


		private String productDescription;

		private double productPrice;

		private String productQuantity;
		
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

		public String getProductQuantity() {
			return productQuantity;
		}

		public void setProductQuantity(String productQuantity) {
			this.productQuantity = productQuantity;
		
		}
	
		
}
				/*public String getProductCondition() {
			return productCondition;
		}

		public void setProductCondition(String productCondition) {
			this.productCondition = productCondition;
		
	}*/