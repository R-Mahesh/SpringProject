package com.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Category(){}
	public Category(int sp,String sup1,String sup2,String sup3,String sup4,String sup5,String sup6,String sup7,String sup8){
		this.sp=sp;
		this.sup1=sup1;
		this.sup2=sup2;
		this.sup3=sup3;
		this.sup4=sup4;
		this.sup5=sup5;
		this.sup6=sup6;
		this.sup7=sup7;
		this.sup8=sup8;
	}

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int sp;
  public int getSp() {
	return sp;
}
public void setSp(int sp) {
	this.sp = sp;
}
@NotEmpty
private String sup1;
  private String sup2;
  private String sup3;
  private String sup4;
  private String sup5;
  private String sup6;
  private String sup7;
  private String sup8;
  @Transient
  private MultipartFile file;
  private String img;
  
  
public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getSup1() {
	return sup1;
}
public void setSup1(String sup1) {
	this.sup1 = sup1;
}
public String getSup2() {
	return sup2;
}
public void setSup2(String sup2) {
	this.sup2 = sup2;
}
public String getSup3() {
	return sup3;
}
public void setSup3(String sup3) {
	this.sup3 = sup3;
}
public String getSup4() {
	return sup4;
}
public void setSup4(String sup4) {
	this.sup4 = sup4;
}
public String getSup5() {
	return sup5;
}
public void setSup5(String sup5) {
	this.sup5 = sup5;
}
public String getSup6() {
	return sup6;
}
public void setSup6(String sup6) {
	this.sup6 = sup6;
}
public String getSup7() {
	return sup7;
}
public void setSup7(String sup7) {
	this.sup7 = sup7;
}
public String getSup8() {
	return sup8;
}
public void setSup8(String sup8) {
	this.sup8 = sup8;
	
}

}
