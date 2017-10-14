package com.niit.eCart.model;

	import java.io.Serializable;

import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Authority implements Serializable {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String username;
		private String role;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}	
		
		
	}