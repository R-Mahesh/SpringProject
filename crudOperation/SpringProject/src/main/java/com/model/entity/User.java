package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import com.model.service.EmpService;


@Entity
public class User implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User(){}
	public User(int id,String name,int age,String password,String phoneNumber){
		this.id=id;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.password=password;
	}

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
 
   @NotEmpty
   @Pattern(regexp="[^0-9]*")
   private String name;
   private String password; 
   private String address;
   @NotEmpty(message = "Phone should not be blank.")
   @Size(min = 10,max = 10)

   private String phoneNumber;
   public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
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


   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }

   
}
