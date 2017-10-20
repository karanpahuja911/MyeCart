
package com.niit.eCart.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.eCart.model.Category;
import com.niit.eCart.model.Product;


public interface ProductService {

List<Product> getAllProduct();

Product getProductById(int productId);

void addProduct(Product product);

void deleteProduct(int productId);

void editProduct(Product product);

void AddCategory(Category category);

}

