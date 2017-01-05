package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carousal implements Serializable{

	/**
	 * 
	 */
	
	public Carousal() {}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int carousal_Id;
	String product1;
	String product2;
	String product3;
	String product4;
	/*String product5;
	String product6;
	String product7;
	String product8;*/
	/*public String getProduct5() {
		return product5;
	}
	public void setProduct5(String product5) {
		this.product5 = product5;
	}
	public String getProduct6() {
		return product6;
	}
	public void setProduct6(String product6) {
		this.product6 = product6;
	}
	public String getProduct7() {
		return product7;
	}
	public void setProduct7(String product7) {
		this.product7 = product7;
	}
	public String getProduct8() {
		return product8;
	}
	public void setProduct8(String product8) {
		this.product8 = product8;
	}
	*/
	public int getCarousal_Id() {
		return carousal_Id;
	}
	public void setCarousal_Id(int carousal_Id) {
		this.carousal_Id = carousal_Id;
	}
	public String getProduct1() {
		return product1;
	}
	public void setProduct1(String product1) {
		this.product1 = product1;
	}
	public String getProduct2() {
		return product2;
	}
	public void setProduct2(String product2) {
		this.product2 = product2;
	}
	public String getProduct3() {
		return product3;
	}
	public void setProduct3(String product3) {
		this.product3 = product3;
	}
	public String getProduct4() {
		return product4;
	}
	public void setProduct4(String product4) {
		this.product4 = product4;
	}
	
}
