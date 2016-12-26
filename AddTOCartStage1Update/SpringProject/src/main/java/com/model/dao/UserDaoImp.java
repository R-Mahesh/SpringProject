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

import com.model.entity.User;
import com.model.entity.User_authorization;
@Repository
public class UserDaoImp implements UserDao{

	
	@Autowired
	private SessionFactory sessionFactory2;
	
	
	
	
	 @Transactional(propagation=Propagation.SUPPORTS)
	public int addUser (User user)
	{    Session session = sessionFactory2.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(user);
	  tx.commit();
	  Serializable id = session.getIdentifier(user);
	  session.close();
	  return (Integer) id;	
	  }
	
	 @Transactional(propagation=Propagation.SUPPORTS)
	public int editUser(User user)
	{
		  Session session = sessionFactory2.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(user);
		  tx.commit();
		  Serializable id = session.getIdentifier(user);
		  session.close();
		  return (Integer) id;
		
	}
	
	 @Transactional(propagation=Propagation.SUPPORTS)
	public int deleteUser (int id)
	{
		 Session session = sessionFactory2.openSession();
		  Transaction tx = session.beginTransaction();
		  User_authorization User_ath = new User_authorization();
		  User_authorization Userath=(User_authorization)session.load(User_authorization.class, id);
		  session.delete(Userath);
		  User user = (User) session.load(User.class, id);
		 
		  session.delete(user);
		  tx.commit();
		  Serializable ids = session.getIdentifier(user);
		 
		  session.close();
		  return (Integer) ids;
		
	}
	 @Transactional(propagation=Propagation.SUPPORTS)
	public User getUser(int id)
	{
		 Session session = sessionFactory2.openSession();
		  User user = (User) session.load(User.class, id);
		  session.close();
		  return user;
		
	}
	
	 @Transactional(propagation=Propagation.SUPPORTS)
public List<User> getAllUser(){
		  Session session = sessionFactory2.openSession();
		  @SuppressWarnings("unchecked")
		  List<User> userList = session.createQuery("from User").list();
		  session.close();
		  return userList;
		  }

	 @Transactional
	public int addAuth(User_authorization user_authorization) {
		 Session session = sessionFactory2.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(user_authorization);
		  tx.commit();
		  Serializable id = session.getIdentifier(user_authorization);
		  session.close();
		  return (Integer) id;	
	}

	

	@Transactional
	public List<User> getUserByName(String username) {
		 Session session =  sessionFactory2.openSession();
		  String Query="from User where userName='"+username+"'";
		  @SuppressWarnings("unchecked")
		  List<User> productList = session.createQuery(Query).list();
		 session.close();
		  return productList;
	}


	
}

