package com.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MyCart implements Serializable {

	/**
	 * 
	 */
	
	public MyCart(){}
	private static final long serialVersionUID = 1L;
	/*public MyCart(int cart_id, String user_id, int product_id, int price, int totalPrice, Products product,
			int quantity, Date date_added, String product_Name, CartItem cart) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.price = price;
		this.totalPrice = totalPrice;
		this.product = product;
		this.quantity = quantity;
		this.date_added = date_added;
		this.product_Name = product_Name;
		this.cart = cart;
	}
*/
	@Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   private int cart_id;
	public MyCart(int cart_id, String user_id, int product_id, int price, int totalPrice, int quantity, Date date_added,
			String product_Name, CartItem cartItem_Id, User user_Id2) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.price = price;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.date_added = date_added;
		this.product_Name = product_Name;
		CartItem_Id = cartItem_Id;
		user_Id = user_Id2;
	}
	@Transient
	private String user_id;
		private int product_id;
	private int price;
	private int totalPrice;
	/*@ManyToOne
    @JoinColumn(name = "id")
    private Products product;*/

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	private int quantity;
	private Date date_added;
	private String product_Name;
	 @ManyToOne
     @JsonIgnore
     @JoinColumn(name="cartItem_id")
     private  CartItem CartItem_Id;
	
	public CartItem getCartItem_Id() {
		return CartItem_Id;
	}

	public void setCartItem_Id(CartItem cartItem_Id) {
		CartItem_Id = cartItem_Id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	 /* @ManyToOne
	    @JoinColumn(name = "cartItem_id")
	    private CartItem cart;

	    public CartItem getCart() {
		return cart;
	}

	public void setCart(CartItem cart) {
		this.cart = cart;
	}

	public Products getProduct() {
		return product;
}

	public void setProduct(Products product) {
		this.product = product;
	}
*/
	
	
	
	@OneToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name="id")
private User user_Id;
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
	public User getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(User user_Id) {
		this.user_Id = user_Id;
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
	
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date now) {
		this.date_added = now;
	}

}
