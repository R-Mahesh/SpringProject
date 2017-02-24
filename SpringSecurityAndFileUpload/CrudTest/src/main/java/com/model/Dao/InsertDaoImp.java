package com.model.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.InsertTable;

@Repository
public class InsertDaoImp implements InsertDao {
 
	@Autowired
	SessionFactory session;
	
	@Transactional
	public int addSupplier(InsertTable inserTable) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(inserTable);

		 return 0;
	}

}
