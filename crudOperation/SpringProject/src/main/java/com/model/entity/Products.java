package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Products implements Serializable{
	
	 /**
	 * 
	 */
	
/*	public Products (){}
	public Products(String name,String quantity,String price,String description,String category){
	this.category=category;
		this.name=name;
		this.quantity=quantity;
		this.price=price;
		this.description=description;
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	@Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   private int id;
	  
      private String category;
	   @NotEmpty
       private String name;
       private String quantity;
       private String price;
       private String description;
      /* private String img;*/
     
       public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}














	@Transient
       private MultipartFile file;
       
       public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}*/
		
	
}
