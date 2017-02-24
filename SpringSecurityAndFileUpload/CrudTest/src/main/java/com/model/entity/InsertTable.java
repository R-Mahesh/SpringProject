package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InsertTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsertTable(){}
	@Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
private String name;
	public InsertTable(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}
	private int age;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
