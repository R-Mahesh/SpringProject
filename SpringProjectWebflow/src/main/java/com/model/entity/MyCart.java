package com.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MyCart implements Serializable {

	/**
	 * 
	 */
	public MyCart(){}
	public MyCart(int cart_id,String user_id,int product_id,int price,int quantity,String status,String date_added){
	this.cart_id=cart_id;
		this.user_id=user_id;
		this.product_id=product_id;
		this.price=price;
		this.quantity=quantity;
		this.status=status;
		this.date_added=date_added;
		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   private int cart_id;
	private String user_id;
	private int product_id;
	private int price;
	private int quantity;
	private String status;
	private String date_added;

   /* @OneToMany(cascade = CascadeType.ALL)
	private Set<Products> products;
	public Set<Products> getProducts() {
		return products;
	}
	public void setProducts(Set<Products> products) {
		this.products = products;
	}*/
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate_added() {
		return date_added;
	}
	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

}
