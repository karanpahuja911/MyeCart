package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductDao productDao;

	public List<Product> getAllProduct() {
	
		return productDao.getAllProduct();
	}

	public Product getProductById(int productId) {

		return productDao.getProductById(productId);
	}

	public void addProduct(Product product) {
		
		productDao.addProduct(product);
		
	}

	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}

	public void editProduct(Product product) {
		productDao.editProduct(product);
		
	}
	public List<Category> getAllCategories() {
		return productDao.getAllCategories();
	}

	public void AddCategory(Category category) {
		productDao.AddCategory(category);
		
	}
	
}
