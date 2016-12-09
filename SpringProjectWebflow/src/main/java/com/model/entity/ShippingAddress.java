package com.model.entity;

import java.io.Serializable;


public class ShippingAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShippingAddress(){}
	
	
	private  String userName;
	private String  password;
	private String confirmPassWord;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getConfirmPassWord() {
		return confirmPassWord;
	}
	public void setConfirmPassWord(String confirmPassWord) {
		this.confirmPassWord = confirmPassWord;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
