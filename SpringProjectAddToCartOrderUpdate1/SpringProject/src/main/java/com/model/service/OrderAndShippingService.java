package com.model.service;

import com.model.entity.Orders;
import com.model.entity.ShipmentDetail;

public interface OrderAndShippingService {

	public void addSupplier(ShipmentDetail shipmentDetail);
	public void addOrderDetails(Orders order);
}
