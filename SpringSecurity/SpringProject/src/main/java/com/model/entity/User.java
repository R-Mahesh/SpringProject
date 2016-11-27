package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class User implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User(){}
	public User(int id,String name,String password,boolean enabled){
		this.id=id;
		this.name=name;
		this.enabled=enabled;
		this.password=password;
	}

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
 
   @NotEmpty
   @Pattern(regexp="[^0-9]*")
   private String name;
   private String password; 
   private boolean enabled;
  /* @NotEmpty(message = "Phone should not be blank.")
   @Size(min = 10,max = 10)*/

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


   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }

   
}
