package com.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Emp  {

	
@Id
private int eid;
private String name;
private String address;
private String email;
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
