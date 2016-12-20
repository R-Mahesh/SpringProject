package com.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.CategoryEntity;
import com.model.entity.MyCart;
import com.model.entity.Products;
import com.model.entity.User;
import com.model.service.AdminService;
import com.model.service.CartService;
/*import com.model.service.ProductService;*/
import com.model.service.ProductService;
import com.model.service.UserService;

@Controller
public class MyController {

	@Autowired
    ServletContext servletContext;
	
	 @Autowired
	 private ProductService productService;
	 
	 
	 @Autowired
	 private AdminService adminService;
	 
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private CartService cartService;
	
	 
	 @ModelAttribute("categoryEntity") 
	 public CategoryEntity bindCategory()
	 {
		 return new CategoryEntity();
	 }
	 @ModelAttribute("user") 
	 public User bindUser()
	 {
		 return new User();
	 }
	
	 
	/* 
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logoutPage (HttpServletRequest request, HttpServletResponse response,Model model) {
		 System.out.println("in login logout method");
		 model.addAttribute("log",true);
	     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     if (auth != null){    
	         new SecurityContextLogoutHandler().logout(request, response, auth);
	     }
		 model.addAttribute("log",true);
	     return "index";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	 }	 */
	 
	 @RequestMapping("/baba")
	 public  @ResponseBody List<Products>  fileShow()
	 {   
		 return productService.getAllProducts();
	 }
	 
	 @RequestMapping("/angularTest")
	 public   String  fileShow2()
	 {   
		 return "angularTest";
	 }
	
	 
	 
	 
	 
	 
		@RequestMapping(value={"/","index"})
		public ModelAndView showMessage(Model model,String check)
				 {
			System.out.println("in index controller");
	 model.addAttribute("homePage",true);
	
	  List categoryList = adminService.getAllCategory();
	    
	  return new ModelAndView("index", "categoryList", categoryList);
		}
		
		@RequestMapping(value="/category",method=RequestMethod.GET)
		 public ModelAndView registerUser(@RequestParam("id")String id,Model model) {
	    	 List productList = productService.getProductsByCategory(id);
	    	  List categoryList = adminService.getAllCategory();
	    	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 		 String username = auth.getName();  //get logged in username
	 		 List userDetail = userService.getUserByName(username);
	 		System.out.println(username);
	 		 model.addAttribute("userDetail", userDetail);
	    	  model.addAttribute("categoryList", categoryList);
	    	  model.addAttribute("productDisplay",true);
	    	  model.addAttribute("homePage",true);
	    	
		  return new ModelAndView("index","productList", productList);
		 }
   
		 @ModelAttribute("user") 
		 public User bind(){
			 
			 return new User();
		 }
		
	@RequestMapping(value="/login")	 
public ModelAndView saveRecord(@ModelAttribute("user")User user,Model modal,@RequestParam(required = false) String authfailed, String logout,String denied)
{ 		
		
		
		System.out.println("in login  meth");
		
		String message = "";
		message="Welcome Login to Continue";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		} else if (denied != null) {
			message = "Access denied for this user !";
		}
		modal.addAttribute("homePage",true);
		modal.addAttribute("no","notValid");
		
		modal.addAttribute("message", message);
		 List categoryList = adminService.getAllCategory();
		  return new ModelAndView("index", "categoryList", categoryList);
	
} 
	
	 @RequestMapping(value="/user",method=RequestMethod.GET)
		public ModelAndView user(Model model)
				 {
		 MyCart myCart = new MyCart();
		 User user = new User();
			myCart.setUser_Id(user);
		
		 model.addAttribute("homePage",true);
		 model.addAttribute("userPage",true);
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String username = auth.getName(); //get logged in username
		 model.addAttribute("username",username);
			System.out.println("in user controller method");
			 List categoryList = adminService.getAllCategory();
			  return new ModelAndView("index", "categoryList", categoryList);
		}
		
	}


		 
		 
