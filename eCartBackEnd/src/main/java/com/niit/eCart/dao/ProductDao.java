package com.niit.eCart.dao;
import java.util.List;

import com.niit.eCart.model.Category;
import com.niit.eCart.model.Product;

public interface ProductDao {
	
    void addProduct(Product product);

public List<Product> getAllProduct();

public Product getProductById(int productId);

void deleteProduct(int productId);

void editProduct(Product product);


public void AddCategory(Category category);

List<Category> getAllCategories();

}
