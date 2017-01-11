package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.OrderAndShippingDao;
import com.model.entity.Orders;
import com.model.entity.ShipmentDetail;

@Service
public class OrderAndShippingServiceImp implements OrderAndShippingService{

	@Autowired
	OrderAndShippingDao orderAndShippingDao;
	
	@Transactional
	public void addSupplier(ShipmentDetail shipmentDetail) {
		// TODO Auto-generated method stub
		orderAndShippingDao.addSupplier(shipmentDetail);
	}


	@Transactional
	public void addOrderDetails(Orders order) {
		// TODO Auto-generated method stub
		orderAndShippingDao.addOrderDetails(order);
	}
	
	
	

}
