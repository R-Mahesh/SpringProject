package com.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.CategoryEntity;
import com.model.entity.User;
import com.model.service.AdminService;
@Controller
public class AdminController {

	@Autowired
    ServletContext context;
	
	 @Autowired
	 private AdminService adminService;
	 
	 @ModelAttribute("categoryEntity") 
	 public CategoryEntity bind()
	 {
		 return new CategoryEntity();
	 }
	 @ModelAttribute("user") 
	 public User bind3()
	 {
		 return new User();
	 }
	 
	  @RequestMapping("Admin")
	 public String admin(Model model) {
	  //empService.add(emp);
		  model.addAttribute("AdminPage",true);
	  return "index";
	 }
	 
	  @RequestMapping(value="addSuppliers",method=RequestMethod.POST)	 
	     public ModelAndView AdminRecord(@Valid @ModelAttribute("categoryEntity")CategoryEntity categoryEntity,BindingResult bindingResult,ModelMap m)
	     { 
		  if (bindingResult.hasErrors())
			{
				return new ModelAndView("Admin");
			}
		 
		  adminService.addSupplier(categoryEntity);
		  
						
						
						return new ModelAndView("Admin");
					
					
				}
					  
	     

	  @RequestMapping("categorylist")
		 public ModelAndView getListCategory(@ModelAttribute("categoryEntity")CategoryEntity categoryEntity,Model model) {
		  List<CategoryEntity> categoryList = adminService.getAllCategory();
		  model.addAttribute("categoryPage",true);
		  return new ModelAndView("index", "categoryList", categoryList);
		 }
		/* 
	     @RequestMapping("category")
	     public ModelAndView getEditCategory(@ModelAttribute("category")Category category,Model model) {
			  List categoryList = adminService.getAllCategory();
			  model.addAttribute("homePage",true);
			  return new ModelAndView("category", "categoryList", categoryList);
			 }*/
	     
@RequestMapping("deleteCategory")
		 public ModelAndView deleteCategory(@RequestParam int sp) {
	    	 adminService.deleteCategory(sp);
		  return new ModelAndView("category");
		 }

		 @RequestMapping("updateCategory")
		 public ModelAndView updateCategory(@Valid @ModelAttribute CategoryEntity categoryEntity,BindingResult bindingResult,ModelMap m) {
			
			 if (bindingResult.hasErrors())
				{
					return new ModelAndView("editCategory");
				}
			
						adminService.addSupplier(categoryEntity);
						adminService.editCategory(categoryEntity);
						  return new ModelAndView("redirect:categorylist");
					
					
		 }

		 	 
		 @RequestMapping("editCategory")
		 public ModelAndView editCategory(@RequestParam int sp,  @ModelAttribute CategoryEntity categoryEntity) {
			 CategoryEntity categoryObject = adminService.getCategory(sp);
		  return new ModelAndView("editCategory", "categoryObject", categoryObject);
		 }

	  
	  
  
}
