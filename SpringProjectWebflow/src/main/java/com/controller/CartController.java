package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.MyCart;
import com.model.entity.Products;
import com.model.entity.User;
import com.model.service.CartService;
import com.model.service.ProductService;
import com.model.service.UserService;

@Controller
public class CartController {
	
	@Autowired
	 private UserService userService;
	
	 @Autowired
	 private ProductService productService;
	
	
	 @Autowired
	 private CartService cartService;
	 
	 @ModelAttribute("user") 
	 public User bindUser()
	 {
		 return new User();
	 } 
	 
	 @ModelAttribute("myCart") 
	 public MyCart bindCart()
	 {
		 return new MyCart();
	 } 
	 
	 
	 
	@RequestMapping("/details")
	public ModelAndView detailPage(@RequestParam("productId") int productId,Model modal)
	{
		 
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 		 String username = auth.getName();  //get logged in username
 		Products productDetail = productService.getProducts(productId);
 		 List userDetail = userService.getUserByName(username);
 		System.out.println(username);
 		 modal.addAttribute("productDetail", productDetail);
 		 modal.addAttribute("userDetail", userDetail);
		return new ModelAndView ("details");
		
	}
	@RequestMapping(value="/addToCart")	 
	public ModelAndView saveRecord(@ModelAttribute("myCart")MyCart myCart,Model modal)
	{ 		
			
		cartService.addCart(myCart);
			System.out.println("in login  meth");
			
		
			  return new ModelAndView("details");
		
	} 
	
	
}
