package com.model.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.Carousal;
@Repository
public class CarousalDaoImp implements CarousalDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
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
	@Transactional
	public Carousal getCarousal(int sp) {
		 Session session = sessionFactory.openSession();
		 Carousal ctgy = (Carousal) session.load(Carousal.class, sp);
		 session.close();
		  return ctgy;
			}
	
	
	
	
	
}
