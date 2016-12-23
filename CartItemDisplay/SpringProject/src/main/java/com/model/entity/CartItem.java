package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CartItem(){}
	/*public CartItem(int cartItem_id,String user_id,int product_id,int price,int quantity){
	this.cartItem_id=cartItem_id;
		this.user_id=user_id;
		this.product_id=product_id;
		this.price=price;
		this.quantity=quantity;

		
	}
*/	
	@Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   private int cartItem_id;
	private String user_id;
	private int product_id;
	private int price;
	private int quantity;

	
	public int getCartItem_id() {
		return cartItem_id;
	}
	public void setCartItem_id(int cartItem_id) {
		this.cartItem_id = cartItem_id;
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

	

}
