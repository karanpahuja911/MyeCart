
package com.niit.service;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;


public interface ProductService {

List<Product> getAllProduct();

Product getProductById(int productId);

void addProduct(Product product);

void deleteProduct(int productId);

void editProduct(Product product);

void AddCategory(Category category);



}

