package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShipmentDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ShipmentDetail() {}
	
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int shipment_id;
	private String name;
	public ShipmentDetail(int shipment_id, String name, long phoneNumber, String address, CartItem cart_id) {
		super();
		this.shipment_id = shipment_id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.cart_id = cart_id;
	}

	private long phoneNumber;
	private String address;
	@OneToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name="cartItem_id")
	private CartItem cart_id;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getShipment_id() {
		return shipment_id;
	}
	public void setShipment_id(int shipment_id) {
		this.shipment_id = shipment_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public CartItem getCart_id() {
		return cart_id;
	}
	public void setCart_id(CartItem cart_id) {
		this.cart_id = cart_id;
	}
}
