package com.model.dao;

import com.model.entity.Orders;
import com.model.entity.ShipmentDetail;

public interface OrderAndShippingDao {

	public void addSupplier(ShipmentDetail shipmentDetail);
	public void addOrderDetails(Orders order);
}
