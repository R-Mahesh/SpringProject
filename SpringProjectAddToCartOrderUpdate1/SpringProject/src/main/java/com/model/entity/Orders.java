package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Orders implements Serializable {


	private static final long serialVersionUID = 1L;
	
	public Orders() {}
	
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int order_Id;
	public Orders(int order_Id, User user_Id, CartItem cart_Id, ShipmentDetail shipmentDetail, String status) {
		super();
		this.order_Id = order_Id;
		this.user_Id = user_Id;
		this.cart_Id = cart_Id;
		this.shipmentDetail = shipmentDetail;
		this.status = status;
	}

	@OneToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name="id")
	private User user_Id;
	@OneToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name="cartItem_id")
	private CartItem cart_Id;
	@OneToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name="shipment_id")
    private ShipmentDetail shipmentDetail;
	private String status;

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ShipmentDetail getShipmentDetail() {
		return shipmentDetail;
	}
	public void setShipmentDetail(ShipmentDetail shipmentDetail) {
		this.shipmentDetail = shipmentDetail;
	}
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public User getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(User user_Id) {
		this.user_Id = user_Id;
	}
	public CartItem getCart_Id() {
		return cart_Id;
	}
	public void setCart_Id(CartItem cart_Id) {
		this.cart_Id = cart_Id;
	}
	
	

}
