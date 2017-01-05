package com.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.Carousal;
import com.model.entity.CategoryEntity;
@Repository
public class AdminDaoImp implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
		public int addSupplier(CategoryEntity categoryEntity)
		{     
			 Session session = sessionFactory.openSession();
			 Transaction tx = session.beginTransaction();
			  session.saveOrUpdate(categoryEntity);
			  
			  tx.commit();
			  Serializable id = session.getIdentifier(categoryEntity);
			 session.close();
			  return (Integer) id;
		  }
		
	@Override
	 public List<CategoryEntity> getAllCategory(){
	 		  Session session = sessionFactory.openSession();
	 		  @SuppressWarnings("unchecked")
	 		  
	 		  List<CategoryEntity> employeeList = session.createQuery("from CategoryEntity").list();
	 	     session.close();
	 		  return employeeList;
	 		  }

	 		
		 
		 
	@Override
	public int editCategory(CategoryEntity categoryEntity) {
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(categoryEntity);
		 tx.commit();
		  Serializable sp = session.getIdentifier(categoryEntity);
		session.close();
		  return (Integer) sp;
				}

	@Override
		public int deleteCategory(int sp) {
			Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
			  CategoryEntity ctgy = (CategoryEntity) session.load(CategoryEntity.class, sp);
			  session.delete(ctgy);
			 tx.commit();
			  Serializable ids = session.getIdentifier(ctgy);
			  session.close();
			  return (Integer) ids;
					}
	@Override
		public CategoryEntity getCategory(int sp) {
			 Session session = sessionFactory.openSession();
			 CategoryEntity ctgy = (CategoryEntity) session.load(CategoryEntity.class, sp);
			 session.close();
			  return ctgy;
				}
	@Override
	@Transactional
	public int addCarousal(Carousal carousal)
	{     
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(carousal);
		  
		  tx.commit();
		  Serializable id = session.getIdentifier(carousal);
		 session.close();
		  return (Integer) id;
	  }
	/*@Transactional*/
	@Override
	@Transactional
	public Carousal getCarousal(int sp) {
		 Session session = sessionFactory.openSession();
		 Carousal ctgy = (Carousal) session.load(Carousal.class, sp);
		 session.close();
		  return ctgy;
			}
	
	@Override
	 public List<Carousal> getCarousalproducts(){
	 		  Session session = sessionFactory.openSession();
	 		  @SuppressWarnings("unchecked")
	 		  
	 		  List<Carousal> employeeList = session.createQuery("from Carousal").list();
	 	       session.close();
	 		  return employeeList;
	 		  }
	 
}
