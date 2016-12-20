package com.model.entity;

import java.io.Serializable;
import java.util.Locale.Category;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Products implements Serializable{
	
	 /**
	 * 
	 */
	
public Products (){}
	public Products(int id,String name,String quantity,String price,String description,String category,CategoryEntity categories){
	    this.id=id;
		this.category=category;
		this.name=name;
		this.quantity=quantity;
		this.price=price;
		this.description=description;
		this.categories=categories;
	}
	
	
	
	private static final long serialVersionUID = 1L;
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int id;
	
	/*@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="categoryname")
    */  private String category;
	   @NotEmpty
       private String name;
       private String quantity;
       private String price;
       private String description;
       @ManyToOne
       @JoinColumn(name="categoryId")
       private CategoryEntity categories;
      public CategoryEntity getCategories() {
		return categories;
	}
	public void setCategories(CategoryEntity categories) {
		this.categories = categories;
	}
	/* @ManyToOne
       @JoinColumn(name = "cart_id")
     private MyCart myCart;
     */
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
	
		
	
}
