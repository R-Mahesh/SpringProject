package com.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class MyCart implements Serializable {

	/**
	 * 
	 */
	public MyCart(){}
	
	public MyCart(int cart_id,String user_id,int product_id,int price,int quantity,Date date_added,User user_Id,String product_Name)
	{
	
		this.cart_id=cart_id;
		this.user_id=user_id;
		this.product_id=product_id;
		this.price=price;
		this.quantity=quantity;
		this.date_added=date_added;
		this.user_Id=user_Id;
		this.product_Name=product_Name;
		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   private int cart_id;
	@Transient
	private String user_id;
	private int product_id;
	private int price;
	private int quantity;
	private Date date_added;
	private String product_Name;
	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	@OneToOne(cascade = CascadeType.ALL)
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
