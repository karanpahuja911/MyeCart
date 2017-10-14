package com.niit.eCart.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.eCart.dao.ProductDao;
import com.niit.eCart.model.Category;
import com.niit.eCart.model.Product;

@Repository("ProductDao")
@Transactional
public  class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	public List<Product> getAllProduct() {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> products=query.list();
		session.flush();
		session.close();
		return products;
	}

	public Product getProductById(int productId) {
		Session session=sessionfactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.flush();
		session.close();
		return product;
	}

	public void addProduct(Product product) {
		Session session=sessionfactory.openSession();
		session.saveOrUpdate(product);
		session.flush();
		session.close();
	}

	public void deleteProduct(int productId) {
		Session session=sessionfactory.openSession();
		//Make the object persistent[read the data from the table and add it to session]
		Product product=(Product)session.get(Product.class, productId);
		session.delete(product);
		session.flush();
		session.close();
		
	}
	
	 public void editProduct (Product product){
	        Session session = sessionfactory.openSession();
	        System.out.println("Id of the product in dao is " + product.getProductId());
	        session.update(product);
	        session.flush();
	        session.close();
	    }

	public void AddCategory(Category category) {
		   Session session = sessionfactory.openSession();
	        session.saveOrUpdate(category);
	        session.flush();
	        session.close();
	}

	public List<Category> getAllCategories()
			{ 
				Session session = sessionfactory.openSession();
				Query query = session.createQuery("from Category");
				List<Category> categories = query.list();
				return categories;
			}
		
		
		}