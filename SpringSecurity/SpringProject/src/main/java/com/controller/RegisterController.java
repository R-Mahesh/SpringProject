package com.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.User;
import com.model.service.AdminService;
import com.model.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	 private AdminService adminService;
	
	
	 @Autowired
	 private UserService userService;
		
	 
	  
	 @ModelAttribute("user") 
	 public User bind(){
		 
		 return new User();
	 }
	 
	     @RequestMapping("register")
		 public ModelAndView registerUser(@ModelAttribute("user")User user,Model model) {
		  //UserService.add(User);
	    	 model.addAttribute("registerPage",true);
		  return new ModelAndView("index");
		 }
		 
	    
		 
	@RequestMapping(value="addUser",method=RequestMethod.POST)	 
public ModelAndView saveRecord(@ModelAttribute("user")User user,BindingResult bindingResult,Model model)
{ 
		if (bindingResult.hasErrors()) {
			return new ModelAndView("register");
}
		userService.addUser(user);
		 model.addAttribute("homePage",true);
		  List categoryList = adminService.getAllCategory();
		  return new ModelAndView("index", "categoryList", categoryList);
}
		 @RequestMapping("listUser")
		 public ModelAndView getList() {
		  List userList = userService.getAllUser();
		  return new ModelAndView("final", "userList", userList);
		 }
		

		 @RequestMapping("deleteUser")
		 public ModelAndView deleteUser(@RequestParam int id) {
		  userService.deleteUser(id);
		  return new ModelAndView("redirect:list");
		 }

		 @RequestMapping("updateUser")
		 public ModelAndView updateUser(@ModelAttribute User user) {
		  userService.editUser(user);
		  return new ModelAndView("redirect:list");
		 }

		 
		 @RequestMapping("editUser")
		 public ModelAndView editUser(@RequestParam int id,@ModelAttribute User user) {
		  User userObject = userService.getUser(id);
		  return new ModelAndView("edit", "userObject", userObject);
		 }
		 
		 @RequestMapping("detailsUser")
		 public ModelAndView useDetails(@ModelAttribute User user,@RequestParam int action) {
			 
		  User userObject = userService.getUser(action);
		  return new ModelAndView("userDetails", "userObject", userObject);
		  }
		 
}