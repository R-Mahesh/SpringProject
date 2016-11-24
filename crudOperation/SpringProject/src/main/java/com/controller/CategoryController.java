package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.User;
import com.model.service.AdminService;
import com.model.service.ProductService;
@Controller
public class CategoryController {

	 @Autowired
	 private ProductService productService;
	
	 @Autowired
	 private AdminService adminService;
	
	 @ModelAttribute("emp") 
	 public User bind(){
		 
		 return new User();
	 }
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public  ModelAndView showMessage(@PathVariable("id")String id,Model model)
			 {
		model.addAttribute("productDisplay",true);
		model.addAttribute("homePage",true);
		System.out.println("in controller");
		System.out.println(id);
	List categoryList = adminService.getAllCategory();
		List productList = productService.getProductsByCategory(id);
		 model.addAttribute("productList", productList);
		  return new ModelAndView("index", "categoryList", categoryList);
		
	}

	}
