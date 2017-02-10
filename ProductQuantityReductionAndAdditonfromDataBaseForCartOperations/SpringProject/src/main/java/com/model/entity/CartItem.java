package com.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class CartItem {
	@Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   private int cartItem_id;
	
	@OneToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name="id")
	private User user_id;
	@OneToMany(mappedBy = "CartItem_Id",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	private List<MyCart> cart_Items;
	private long grandTotal;
	 /*@OneToMany(mappedBy = "CartItem", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    private List<MyCart> myCart;*/
	
	public long getGrandTotal() {
		return grandTotal;
	}





	public void setGrandTotal(long grandTotal) {
		this.grandTotal = grandTotal;
	}





	/* @ManyToOne
	 @JoinColumn(name="id")
	 private Products products;
	*/
	/**
	 * 
	 */
	public CartItem(){}
	

	
	
	 
	/*public CartItem(int cartItem_id, String user_id,  int price, int quantity, 
			Products products,long grandTotal) {
		super();
		this.cartItem_id = cartItem_id;
		
	
		this.grandTotal=grandTotal;
		this.products = products;
	}*/





/*	public List<MyCart> getMyCart() {
		return myCart;
	}





	public void setMyCart(List<MyCart> myCart) {
		this.myCart = myCart;
	}

*/



	public List<MyCart> getCart_Items() {
		return cart_Items;
	}





	public User getUser_id() {
		return user_id;
	}





	public CartItem(int cartItem_id, User user_id, List<MyCart> cart_Items, long grandTotal) {
		super();
		this.cartItem_id = cartItem_id;
		this.user_id = user_id;
		this.cart_Items = cart_Items;
		this.grandTotal = grandTotal;
	}





	public void setCart_Items(List<MyCart> cart_Items) {
		this.cart_Items = cart_Items;
	}





	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}





	public int getCartItem_id() {
		return cartItem_id;
	}
/*	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
*/	public void setCartItem_id(int cartItem_id) {
		this.cartItem_id = cartItem_id;
	}
	
	

	

}
