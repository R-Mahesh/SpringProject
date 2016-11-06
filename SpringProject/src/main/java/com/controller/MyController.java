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

import com.model.entity.Emp;
import com.model.service.EmpService;

@Controller
public class MyController {

	 @Autowired
	 private EmpService empService;
		@RequestMapping(value={"/","index"})
		public ModelAndView showMessage(@ModelAttribute("emp")Emp emp,Model model)
				 {
			System.out.println("in controller");
	 model.addAttribute("homePage",true);
			  return new ModelAndView("index");
		}
		
	     @RequestMapping("register")
		 public ModelAndView registerUser(@ModelAttribute("emp")Emp emp,Model model) {
		  //empService.add(emp);
	    	 model.addAttribute("registerPage",true);
		  return new ModelAndView("index");
		 }
		 
	     @RequestMapping("Admin")
		 public String admin() {
		  //empService.add(emp);
		  return "Admin";
		 }
	     
		 
	@RequestMapping(value="add",method=RequestMethod.POST)	 
public ModelAndView saveRecord(@ModelAttribute("emp")Emp emp,BindingResult bindingResult)
{ 
		if (bindingResult.hasErrors()) {
			return new ModelAndView("register");
}
		empService.add(emp);
		return new ModelAndView("index");
}
		 @RequestMapping("list")
		 public ModelAndView getList() {
		  List employeeList = empService.getAllEmp();
		  return new ModelAndView("final", "employeeList", employeeList);
		 }
		

		 @RequestMapping("delete")
		 public ModelAndView deleteUser(@RequestParam int id) {
		  empService.delete(id);
		  return new ModelAndView("redirect:list");
		 }

		 @RequestMapping("update")
		 public ModelAndView updateUser(@ModelAttribute Emp emp) {
		  empService.edit(emp);
		  return new ModelAndView("redirect:list");
		 }

		 
		 @RequestMapping("edit")
		 public ModelAndView editUser(@RequestParam int id,
		   @ModelAttribute Emp emp) {
		  Emp employeeObject = empService.getEmp(id);
		  return new ModelAndView("edit", "employeeObject", employeeObject);
		 }

}