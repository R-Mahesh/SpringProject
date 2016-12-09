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
import com.model.entity.CategoryEntity;
import com.model.entity.Products;
@Repository
public class AdminDaoImp implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
		public int addSupplier(CategoryEntity categoryEntity)
		{     
			 Session session = sessionFactory.openSession();
			// Transaction tx = session.beginTransaction();
			  session.saveOrUpdate(categoryEntity);
			  
			 // tx.commit();
			  Serializable id = session.getIdentifier(categoryEntity);
			 //session.close();
			  return (Integer) id;
		  }
		
	 public List getAllCategory(){
	 		  Session session = sessionFactory.openSession();
	 		  @SuppressWarnings("unchecked")
	 		  List employeeList = session.createQuery("from CategoryEntity").list();
	 		    
	 		// session.close();
	 		  return employeeList;
	 		  }

	 		
		 
		 

		public int editCategory(CategoryEntity categoryEntity) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(categoryEntity);
		 tx.commit();
		  Serializable sp = session.getIdentifier(categoryEntity);
		//session.close();
		  return (Integer) sp;
				}

		public int deleteCategory(int sp) {
			Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
			  CategoryEntity ctgy = (CategoryEntity) session.load(CategoryEntity.class, sp);
			  session.delete(ctgy);
			 tx.commit();
			  Serializable ids = session.getIdentifier(ctgy);
			//  session.close();
			  return (Integer) ids;
					}

		public CategoryEntity getCategory(int sp) {
			 Session session = sessionFactory.openSession();
			 CategoryEntity ctgy = (CategoryEntity) session.load(CategoryEntity.class, sp);
			  return ctgy;
				}

	
	 
	 
	 
	 
}
