package com.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;





@Entity
public class User implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User(){}
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
  
   private int id;
  private String userEmail;
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}



public User(int id, String userEmail, String userName, String confirmPassWord, CartItem cart_id, String password,
		boolean enabled) {
	super();
	this.id = id;
	this.userEmail = userEmail;
	this.userName = userName;
	this.confirmPassWord = confirmPassWord;
	this.cart_id = cart_id;
	this.password = password;
	this.enabled = enabled;
}

@Column(unique=true)
   private String userName;
  /* public User(int id, String userName, String confirmPassWord, CartItem cart_id, String password, boolean enabled) {
	super();
	this.id = id;
	this.userName = userName;
	this.confirmPassWord = confirmPassWord;
	this.cart_id = cart_id;
	this.password = password;
	this.enabled = enabled;
}*/

@Transient
  
   private String confirmPassWord;
   @OneToOne 
	@JoinColumn(name="cartItem_id")
	private CartItem cart_id;

   
   
   
 public CartItem getCart_id() {
	return cart_id;
}
public void setCart_id(CartItem cart_id) {
	this.cart_id = cart_id;
}
public String getConfirmPassWord() {
	return confirmPassWord;
}
public void setConfirmPassWord(String confirmPassWord) {
	this.confirmPassWord = confirmPassWord;
}
private String password; 
   private boolean enabled;
 

public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


   public void setUserName(String userName) {
      this.userName = userName;
   }
   public String getUserName() {
      return userName;
   }

   
}
