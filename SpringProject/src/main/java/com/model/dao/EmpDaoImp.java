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

import com.model.entity.Emp;
@Repository("empDao")
public class EmpDaoImp implements EmpDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	 @Transactional(propagation=Propagation.SUPPORTS)
	public int add (Emp emp)
	{    Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(emp);
	  tx.commit();
	  Serializable id = session.getIdentifier(emp);
	  session.close();
	  return (Integer) id;	
	  }
	
	 @Transactional(propagation=Propagation.SUPPORTS)
	public int edit(Emp emp)
	{
		  Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(emp);
		  tx.commit();
		  Serializable id = session.getIdentifier(emp);
		  session.close();
		  return (Integer) id;
		
	}
	
	 @Transactional(propagation=Propagation.SUPPORTS)
	public int delete (int id)
	{
		 Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  Emp employee = (Emp) session.load(Emp.class, id);
		  session.delete(employee);
		  tx.commit();
		  Serializable ids = session.getIdentifier(employee);
		  session.close();
		  return (Integer) ids;
		
	}
	 @Transactional(propagation=Propagation.SUPPORTS)
	public  Emp getEmp(int id)
	{
		 Session session = sessionFactory.openSession();
		  Emp employee = (Emp) session.load(Emp.class, id);
		  return employee;
		
	}
	
	 @Transactional(propagation=Propagation.SUPPORTS)
public List getAllEmp(){
		  Session session = sessionFactory.openSession();
		  @SuppressWarnings("unchecked")
		  List employeeList = session.createQuery("from Emp").list();
		    
		  session.close();
		  return employeeList;}

}

