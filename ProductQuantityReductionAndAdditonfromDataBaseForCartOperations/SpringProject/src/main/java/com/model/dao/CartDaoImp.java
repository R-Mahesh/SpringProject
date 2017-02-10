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

import com.model.entity.CartItem;
import com.model.entity.MyCart;
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
		  @SuppressWarnings("unchecked")
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
		session.close();
		  return cart;
		
	}

	@Override
	public List<User> getCartByUserClass(User id) {
		 Session session =  sessionFactory3.openSession();
		  String Query="from MyCart where user_Id='"+id+"'";
		  @SuppressWarnings("unchecked")
		  List<User> productList = session.createQuery(Query).list();
		 session.close();
		  return productList;
	}
	@Override
	public int deleteCart(int sp) {
		Session session = sessionFactory3.openSession();
	 Transaction tx = session.beginTransaction();
	 MyCart crt = (MyCart) session.load(MyCart.class, sp);
	 
	 crt.getCartItem_Id().getCart_Items().remove(crt);
		  session.delete(crt);
		 tx.commit();
		  Serializable ids = session.getIdentifier(crt);
		  session.close();
		  return (Integer) ids;
				}

	@Transactional
	public int addCarts(CartItem cartItems) {
		Session session =  sessionFactory3.openSession();
		 Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(cartItems);
		  
		  tx.commit();
		  Serializable id = session.getIdentifier(cartItems);
		 session.close();
		  return (Integer) id;

	}

	@Override
	public List<CartItem> getCartItem() {
		  Session session =  sessionFactory3.openSession();
		  @SuppressWarnings("unchecked")
 		 List<CartItem> cartItem = session.createQuery("from CartItem").list();
 		session.close();
 		  return cartItem;	}

	@Override
	public int deleteCart1(int id) {
		Session session = sessionFactory3.openSession();
		 Transaction tx = session.beginTransaction();
		 MyCart crt = (MyCart) session.load(MyCart.class, id);
		 
			  session.delete(crt);
			 tx.commit();
			  Serializable ids = session.getIdentifier(crt);
			  session.close();
			  return (Integer) ids;
		
	}

	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<MyCart> getCartItemById(int id) {
		  Session session =  sessionFactory3.openSession();
		  String Query="from MyCart where user_Id='"+id+"'";
 		  @SuppressWarnings("unchecked")
 		  List<MyCart> cartItemList = session.createQuery(Query).list();
 		 session.close();
 		  return cartItemList;
	}

	@Override
	public int addCartById(MyCart myCart, String id) {
		Session session =  sessionFactory3.openSession();
		 Transaction tx = session.beginTransaction();
		 String Query="UPDATE  MyCart where user_Id='"+id+"'";
		  session.saveOrUpdate(Query);
		  
		  tx.commit();
		  Serializable id1 = session.getIdentifier(myCart);
		 session.close();
		  return (Integer) id1;
	}

	

	
	
}
