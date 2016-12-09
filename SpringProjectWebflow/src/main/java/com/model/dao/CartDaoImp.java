package com.model.dao;


import org.hibernate.SessionFactory;
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
	public void addCart(MyCart myCart) {
		// TODO Auto-generated method stub
		try
		{sessionFactory3.getCurrentSession().saveOrUpdate(myCart);
		}
		
		
		
		catch (Exception e)
		{
	         System.out.println("Error in creating record, rolling back");
	         throw e;
	}
	
	 

	}
}
