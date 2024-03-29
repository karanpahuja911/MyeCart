package com.niit.model;
	import java.io.Serializable;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Category implements Serializable{
		
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private int categoryId;

		private  String categoryName;
		private  String categoryType;
		private  String categoryDescription;
		
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public String getCategoryType() {
			return categoryType;
		}
		public void setCategoryType(String categoryType) {
			this.categoryType = categoryType;
		}
		public String getCategoryDescription() {
			return categoryDescription;
		}
		public void setCategoryDescription(String categoryDescription) {
			this.categoryDescription = categoryDescription;
		}
	}
