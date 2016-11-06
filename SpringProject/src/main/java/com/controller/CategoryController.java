package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.Emp;
@Controller
public class CategoryController {
	@RequestMapping("/first")
	public String showMessage(@ModelAttribute("emp")Emp emp,Model model)
			 {
		System.out.println("in controller");
 
		model.addAttribute("firstPage",true);
		  return "index"; 
	}

	@RequestMapping("/second")
	public String showMessage2(@ModelAttribute("emp")Emp emp,Model model)
			 {
		System.out.println("in controller");
 
		model.addAttribute("secondPage",true);
		  return "index";
	}
	@RequestMapping("/third")
	public  String showMessage3(@ModelAttribute("emp")Emp emp,Model model)
			 {
		System.out.println("in controller");
 
		model.addAttribute("thirdPage",true);
		  return "index";
		  }
	@RequestMapping("/fourth")
	public  String showMessage4(@ModelAttribute("emp")Emp emp,Model model)
			 {
		System.out.println("in controller");
 
		model.addAttribute("fourthPage",true);
		  return "index";
		  }
	@RequestMapping("/fifth")
	public  String showMessage5(@ModelAttribute("emp")Emp emp,Model model)
			 {
		System.out.println("in controller");
 
		model.addAttribute("fifthPage",true);
		  return "index";
		  }
	@RequestMapping("/sixth")
	public  String showMessage6(@ModelAttribute("emp")Emp emp,Model model)
			 {
		System.out.println("in controller");
 
		model.addAttribute("sixthPage",true);
		  return "index";
		  }
	@RequestMapping("/seventh")
	public  String showMessage7(@ModelAttribute("emp")Emp emp,Model model)
			 {
		System.out.println("in controller");
 
		model.addAttribute("seventhPage",true);
		  return "index";	
		  }
	@RequestMapping("/eighth")
	public String showMessage8(@ModelAttribute("emp")Emp emp,Model model)
			 {
		System.out.println("in controller");
 
		model.addAttribute("eighthPage",true);
		 return "index";
	}
}
