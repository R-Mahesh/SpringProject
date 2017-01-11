package com.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.Carousal;
import com.model.entity.User;
import com.model.entity.User_authorization;
import com.model.service.AdminService;
import com.model.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	 private AdminService adminService;
	
	
	 @Autowired
	 private UserService userService;
		
	
	  
	@ModelAttribute("user")
	public User binding()
	{
		return new User();
	}
	/*@RequestMapping("/register")
	public String registerFunction()
	{
		return "register";
	}*/
		 
	@RequestMapping(value="addUser",method=RequestMethod.POST)	 
public ModelAndView saveRecord(@Valid @ModelAttribute("user")User user,BindingResult bindingResult,Model model)
{ 
		if (bindingResult.hasErrors()) {
			return new ModelAndView ("register");
}
		
		if((user.getConfirmPassWord().equals(user.getPassword()))== false){
			
			return new ModelAndView ("register","mismatch","passwordMissMatch");
		}
		
		User_authorization athz = new User_authorization();
		athz.setRole("ROLE_USER");
		athz.setId_fk(user);
		user.setEnabled(true);
		
		
		userService.addUser(user);
		userService.addAuth(athz);
		
		 model.addAttribute("homePage",true);
		  List categoryList = adminService.getAllCategory();
		  model.addAttribute("pop",true);
		  List<Carousal> crdl=adminService.getCarousalproducts();
			 for(Carousal cpdl:crdl)
				 
			 {
				 model.addAttribute("carousalProduct", cpdl);
			 }
		  return new ModelAndView("index", "categoryList", categoryList);
}
		 @RequestMapping("listUser")
		 public ModelAndView getList() {
		  List<User> userList = userService.getAllUser();
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
		  return new ModelAndView("redirect:listUser");
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