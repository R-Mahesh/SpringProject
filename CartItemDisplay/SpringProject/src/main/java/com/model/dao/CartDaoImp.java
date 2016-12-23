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

import com.model.entity.MyCart;
import com.model.entity.Products;
import com.model.entity.User;

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
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<MyCart> getAllCartItem() {
		  Session session =  sessionFactory3.openSession();
 		  
 		 List<MyCart> cartItemList = session.createQuery("from MyCart").list();
 		session.close();
 		  return cartItemList;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public int editMyCart(MyCart myCart) {
		 Session session =  sessionFactory3.openSession();
		 Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(myCart);
		 tx.commit();
		  Serializable id = session.getIdentifier(myCart);
		session.close();
		  return (Integer) id;
	}
	 @Transactional(propagation=Propagation.SUPPORTS)
	public MyCart getCart(int id)
	{
		 Session session = sessionFactory3.openSession();
		 MyCart cart = (MyCart) session.load(MyCart.class, id);
		/* session.close();*/
		  return cart;
		
	}

	
}
