package com.niit.dao;

	import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;

	@Repository
	
	public class SupplierDaoImpl implements SupplierDao {
	
		@Autowired
		private SessionFactory sessionFactory;
		public List<Supplier> getAllSuppliers() {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Supplier");
			List<Supplier> suppliers=query.list();
			session.close();
			return suppliers;
		}
		public Supplier getByName(String name) {
			String hql="from Supplier where supname=?";
	        Query query=sessionFactory.openSession().createQuery(hql);
	        query.setString(0, name);
	       
	        @SuppressWarnings("unchecked")
	        List<Supplier> Supplier=(List<Supplier>) query.list();
	        if(Supplier!=null && !Supplier.isEmpty()){
	             
	              return Supplier.get(0);
	        }
	        else{
	             
	              return null;
	        }
	       
		}
		public void saveOrUpdate(Supplier supplier) {
				Session session=sessionFactory.openSession();
				System.out.println("SUPPLIER ID BEFORE INSERTION " + supplier.getSupplierId());
				session.saveOrUpdate(supplier);
				System.out.println("SUPPLIER ID AFTER INSERTION " + supplier.getSupplierId());
				session.flush();
				session.close();
		}
		public void deleteSupplier(int supid) {
			Session session=sessionFactory.openSession();
			Supplier supplier=(Supplier)session.get(Supplier.class, supid); //persistent
			session.delete(supplier);
			session.flush();
			session.close();
			
		}
		public Supplier getSupplierBySup_Id(int supid) {
			 Session session=sessionFactory.openSession();
		     Supplier supplier=(Supplier)session.get(Supplier.class, supid);
		     session.close();
		     return supplier;
			
		}
		}
