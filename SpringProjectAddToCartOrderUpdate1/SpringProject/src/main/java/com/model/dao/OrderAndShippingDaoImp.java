package com.model.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.entity.Orders;
import com.model.entity.ShipmentDetail;


@Repository
public class OrderAndShippingDaoImp implements OrderAndShippingDao{

	@Autowired
	SessionFactory session;
	
	@Transactional
	public void addSupplier(ShipmentDetail shipmentDetail) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(shipmentDetail);

	}

	@Override
	public void addOrderDetails(Orders order) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(order);
	}

	
}
