package com.model.dao;


import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.MyCart;

@Repository
public class CartDaoImp implements CartDao{

	@Autowired
	private SessionFactory sessionFactory3;
	
	@Transactional
	public int addCart(MyCart myCart) {
		
	
			Session session =  sessionFactory3.openSession();
		 Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(myCart);
		  
		  tx.commit();
		  Serializable id = session.getIdentifier(myCart);
		 session.close();
		  return (Integer) id;
		
	 
	}
}
