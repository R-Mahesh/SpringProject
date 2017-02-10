package com.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Products implements Serializable{
	
	 /**
	 * 
	 */
	/*public void setCategories(CategoryEntity categories) {
	        this.categories = categories;
	        if (!categories.getProducts().contains(this)) { // warning this may cause performance issues if you have a large data set since this operation is O(n)
	        	categories.getProducts().add(this);
	        }
	    }
*/
	public Products(){}

	
	
	
	public Products(int id, String category, String name, int quantity, String price, String description,
			CategoryEntity categories, MultipartFile file) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.categories = categories;
		this.file = file;
	}




	private static final long serialVersionUID = 1L;
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int id;
	
	 private String category;
	   @NotEmpty
	   @Column(unique = true)

       private String name;
       private int quantity;
       private String price;
       private String description;
       @ManyToOne
       @JsonIgnore
       @JoinColumn(name="categoryId")
       private CategoryEntity categories;
      public CategoryEntity getCategories() {
		return categories;
	}
	public void setCategories(CategoryEntity categories) {
		this.categories = categories;
	}
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
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
