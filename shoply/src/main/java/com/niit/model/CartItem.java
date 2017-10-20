package com.niit.model;

	import java.io.Serializable;

	import javax.persistence.*;

	import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	public class CartItem  implements Serializable{
		
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		private int carItemId;
		
		@ManyToOne
		@JoinColumn(name="cartId")
		@JsonIgnore
		private Cart cart;
		
		@ManyToOne
		@JoinColumn(name="productId")
		private Product product;
		
		private int quantity;
		
		private double totalPrice;
		
		public int getCarItemId() {
			return carItemId;
		}
		public void setCarItemId(int carItemId) {
			this.carItemId = carItemId;
		}
		public Cart getCart() {
			return cart;
		}
		public void setCart(Cart cart) {
			this.cart = cart;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}	

	}

	