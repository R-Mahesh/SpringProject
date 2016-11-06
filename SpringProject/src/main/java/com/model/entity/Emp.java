package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.model.service.EmpService;


@Entity
public class Emp implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Emp(){}
	public Emp(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   @NotNull
   private Integer age;
   @NotEmpty
   private String name;
   public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void setAge(Integer age) {
      this.age = age;
   }
   public Integer getAge() {
      return age;
   }

   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }

   
}
