package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.entity.Emp;

@Controller
public class SearchController {

	@RequestMapping(value={"search"})
	public String showMessag2(@ModelAttribute("emp")Emp emp,@RequestParam("Search") String search,Model model)
			 {
		System.out.println("in controller");
		 
 switch(search.toLowerCase())
 { case "first":model.addAttribute("firstPage",true);
		  return "index"; 
 case "second":model.addAttribute("secondPage",true);
	  return "index";
 case "third":model.addAttribute("thirdPage",true);
	  return "index";
 case "fourth":model.addAttribute("fourthPage",true);
	  return "index";
 case "fifth":model.addAttribute("fifthPage",true);
	  return "index";
 case "sixth":model.addAttribute("sixthPage",true);
	  return "index";
 case "seventh":model.addAttribute("seventhPage",true);
	  return "index";
 case "eighth":model.addAttribute("eighthPage",true);
	  return "index";
	 default:model.addAttribute("homePage",true);
		 return "index";
		 }

			 }
}
