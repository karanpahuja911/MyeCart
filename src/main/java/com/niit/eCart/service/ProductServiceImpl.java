package com.niit.eCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.eCart.dao.ProductDao;
import com.niit.eCart.dao.ProductDaoImpl;
import com.niit.eCart.model.Product;

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
	
}
