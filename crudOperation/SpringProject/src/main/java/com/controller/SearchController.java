package com.controller;
import com.controller.MyController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.User;
import com.model.service.*;
@Controller
public class SearchController {
	 @Autowired
	 private AdminService adminService;
	
	@RequestMapping(value={"search"})
	public ModelAndView showMessag2(@ModelAttribute("emp")User emp,@RequestParam("Search") String search,Model model)
			 {
		System.out.println("in controller");
		 
 switch(search.toLowerCase())
 { case "water heater":model.addAttribute("firstPage",true);
 List categoryList = adminService.getAllCategory();
 return new ModelAndView("index", "categoryList", categoryList);
 case "waterheater":model.addAttribute("firstPage",true);
 return new ModelAndView("index");
 case "ironbox":model.addAttribute("secondPage",true);
	  return new ModelAndView("index");
 case "iron box":model.addAttribute("secondPage",true);
 return new ModelAndView("index");

 case "inductionstove":model.addAttribute("thirdPage",true);
	  return new ModelAndView("index");
 case "induction stove":model.addAttribute("thirdPage",true);
 return new ModelAndView("index");

 case "electriccooker":model.addAttribute("fourthPage",true);
	  return new ModelAndView("index");
 case "electric cooker":model.addAttribute("fourthPage",true);
 return new ModelAndView("index");

 case "elecricoven":model.addAttribute("fifthPage",true);
	  return new ModelAndView("index");
 case "elecric oven":model.addAttribute("fifthPage",true);
 return new ModelAndView("index");

 case "waterheaterrod":model.addAttribute("sixthPage",true);
	  return new ModelAndView("index");
 case "water heater rod":model.addAttribute("sixthPage",true);
 return new ModelAndView("index");

 case "toaster":model.addAttribute("seventhPage",true);
	  return new ModelAndView("index");
 case "rotimaker":model.addAttribute("eighthPage",true);
	  return new ModelAndView("index");
 case "roti maker":model.addAttribute("eighthPage",true);
 return new ModelAndView("index");

	 default:model.addAttribute("homePage",true);
	 List categoryList2 = adminService.getAllCategory();
	  return new ModelAndView("index", "categoryList", categoryList2);
		 }

			 }
}
