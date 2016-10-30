package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
		
	 
		@RequestMapping(value={"/","/index"})
		public ModelAndView showMessage()
				 {
			System.out.println("in controller");
	 
			ModelAndView m = new ModelAndView("index");
			
			
			return m;
		}
}