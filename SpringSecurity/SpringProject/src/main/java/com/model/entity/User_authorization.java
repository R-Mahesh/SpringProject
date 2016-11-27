package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User_authorization implements Serializable{

	/**
	 * 
	 */

	
	private static final long serialVersionUID = 1L;
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int role_id;
private int id;
private String role;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getRole_id() {
	return role_id;
}

public void setRole_id(int role_id) {
	this.role_id = role_id;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}
}
