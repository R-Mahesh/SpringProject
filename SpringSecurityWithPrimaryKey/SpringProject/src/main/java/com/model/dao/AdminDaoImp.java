package com.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.Category;
@Repository
public class AdminDaoImp implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
		public int addSupplier(Category category,String s)
		{     
			 Session session = sessionFactory.openSession();
			// Transaction tx = session.beginTransaction();
			 category.setImg(s);
			  session.saveOrUpdate(category);
			  
			 // tx.commit();
			  Serializable id = session.getIdentifier(category);
			 //session.close();
			  return (Integer) id;
		  }
		
	 public List getAllCategory(){
	 		  Session session = sessionFactory.openSession();
	 		  @SuppressWarnings("unchecked")
	 		  List employeeList = session.createQuery("from Category").list();
	 		    
	 		// session.close();
	 		  return employeeList;
	 		  }

	 		
		 
		 

		public int editCategory(Category category) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(category);
		 tx.commit();
		  Serializable sp = session.getIdentifier(category);
		//session.close();
		  return (Integer) sp;
				}

		public int deleteCategory(int sp) {
			Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
			  Category ctgy = (Category) session.load(Category.class, sp);
			  session.delete(ctgy);
			 tx.commit();
			  Serializable ids = session.getIdentifier(ctgy);
			//  session.close();
			  return (Integer) ids;
					}

		public Category getCategory(int sp) {
			 Session session = sessionFactory.openSession();
			 Category ctgy = (Category) session.load(Category.class, sp);
			  return ctgy;
				}
	 
	 
	 
	 
}
