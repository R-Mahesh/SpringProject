package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Dao.InsertDao;
import com.model.entity.InsertTable;

@Service
public class InsetServiceImp implements InsertService{

	@Autowired
	InsertDao insertDao;
	
	@Transactional
	public int addSupplier(InsertTable inserTable) {
		// TODO Auto-generated method stub
		insertDao.addSupplier(inserTable);
		return 0;
	}

}
