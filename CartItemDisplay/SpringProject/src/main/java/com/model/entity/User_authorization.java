package com.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class User_authorization implements Serializable{

	/**
	 * 
	 */

	public User_authorization(){}
	private static final long serialVersionUID = 1L;
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int role_id;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id")
private User id_fk;

public User getId_fk() {
	return id_fk;
}

public void setId_fk(User id_fk) {
	this.id_fk = id_fk;
}

private String role;

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
