package com.model.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.Products;

import java.util.List;

import org.hibernate.Transaction;


@Component
@Repository
public class  ProductDaoImp implements ProductDao{

	@Autowired
	private SessionFactory sessionFctry;
	
	@Transactional
	public int addProducts(Products products, String s) {
		 Session session =  sessionFctry.openSession();
			// Transaction tx = session.beginTransaction();
		 products.setName(s);
			  session.saveOrUpdate(products);
			  
			 // tx.commit();
			  Serializable id = session.getIdentifier(products);
			 //session.close();
			  return (Integer) id;
	}
	
		
	
	@Transactional
	public List getAllProducts() {
		  Session session =  sessionFctry.openSession();
 		  @SuppressWarnings("unchecked")
 		  List productList = session.createQuery("from Products").list();
 		    
 		// session.close();
 		  return productList;
	}
	
	
	@Transactional
	public int editProducts(Products products) {
		 Session session =  sessionFctry.openSession();
		 Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(products);
		 tx.commit();
		  Serializable id = session.getIdentifier(products);
		//session.close();
		  return (Integer) id;
	}

	@Transactional
	public int deleteProducts(int pr) {
		Session session =  sessionFctry.openSession();
		 Transaction tx = session.beginTransaction();
		 Products ptrd = (Products) session.load(Products.class, pr);
			  session.delete(ptrd);
			 tx.commit();
			  Serializable idD = session.getIdentifier(ptrd);
			//  session.close();
			  return (Integer) idD;
	}

	
	@Transactional
	public Products getProducts(int pr) {
		 Session session =  sessionFctry.openSession();
		 Products ptd = (Products) session.load(Products.class, pr);
		  return ptd;
	}


	@Transactional
	public List getProductsByCategory(String id) {
		  Session session =  sessionFctry.openSession();
		  String Query="from Products where category='"+id+"'";
 		  @SuppressWarnings("unchecked")
 		  List productList = session.createQuery(Query).list();
 		    
 		// session.close();
 		  return productList;
	}
	
	
}
