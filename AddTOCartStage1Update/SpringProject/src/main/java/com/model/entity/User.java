package com.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class User implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User(){}
	public User(int id,String userName,String password,boolean enabled){
		this.id=id;
		this.userName=userName;
		this.enabled=enabled;
		this.password=password;
	}

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
  
   private int id;
 
   
   @Column(unique=true)
   private String userName;
   @Transient
   private String confirmPassWord;
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
