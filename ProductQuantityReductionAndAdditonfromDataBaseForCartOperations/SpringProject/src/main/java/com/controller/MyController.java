package com.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.entity.Carousal;
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

	static int cNo;
	
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
	
	 
	
	 @RequestMapping("/success") 
	 public String check()
	 {
		 
		 return "success";
	 }
	
	
	 
	 
	 
	 
	 
		@RequestMapping(value={"/","index"})
		public ModelAndView showMessage(Model model,String check,HttpServletRequest request)
				 {
			System.out.println("in index controller");
	 model.addAttribute("homePage",true);
	 List<Carousal> crdl=adminService.getCarousalproducts();
	 for(Carousal cpdl:crdl)
		 
	 {
		 model.addAttribute("carousalProduct", cpdl);
	 }
	  List<CategoryEntity> categoryList = adminService.getAllCategory();
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String username = auth.getName(); //get logged in username
		 
		 if(!(userService.getUserByName(username).isEmpty())){
			 List<User> userDetail = userService.getUserByName(username);
			List<MyCart> cartItem1 = cartService.getCartItemById(userDetail.get(0).getId());
			 model.addAttribute("cartItem", cartItem1);}
		 model.addAttribute("UserName", username);
	  return new ModelAndView("index", "categoryList", categoryList);
		}
		
		@RequestMapping(value="/category",method=RequestMethod.GET)
		 public ModelAndView registerUser(@RequestParam("id")String id,Model model) {
	    	 List<Products> productList = productService.getProductsByCategory(id);
	    	  List<CategoryEntity> categoryList = adminService.getAllCategory();
	    	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 		 String username = auth.getName();  //get logged in username
	 		 if(!(userService.getUserByName(username).isEmpty())){
				 List<User> userDetail = userService.getUserByName(username);
				List<MyCart> cartItem1 = cartService.getCartItemById(userDetail.get(0).getId());
				 model.addAttribute("cartItem", cartItem1);
				 cNo= cartItem1.size();
				 model.addAttribute("cNo",cNo);
	 		 }
	 		 List<User> userDetail = userService.getUserByName(username);
	 		
	 		System.out.println(username);
	 		 model.addAttribute("userDetail", userDetail);
	    	  model.addAttribute("categoryList", categoryList);
	    	  model.addAttribute("productDisplay",true);
	    	  model.addAttribute("homePage",true);
	    	  List<Carousal> crdl=adminService.getCarousalproducts();
	    		 for(Carousal cpdl:crdl)
	    			 
	    		 {
	    			 model.addAttribute("carousalProduct", cpdl);
	    		 }
	    		 model.addAttribute("UserName", username);
		  return new ModelAndView("index","productList", productList);
		 }
   
		 @ModelAttribute("user") 
		 public User bind(){
			 
			 return new User();
		 }
		
	@RequestMapping(value="/login")	 
public ModelAndView saveRecord(@ModelAttribute("user")User user,Model model,@RequestParam(required = false) String authfailed, String logout,String denied)
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
		model.addAttribute("homePage",true);
		model.addAttribute("no","notValid");
		
		model.addAttribute("message", message);
		 List<CategoryEntity> categoryList = adminService.getAllCategory();
		 List<Carousal> crdl=adminService.getCarousalproducts();
		 for(Carousal cpdl:crdl)
			 
		 {
			 model.addAttribute("carousalProduct", cpdl);
		 }
		  return new ModelAndView("index", "categoryList", categoryList);
	
} 
	
	 @RequestMapping(value="/user",method=RequestMethod.GET)
		public ModelAndView user(Model model)
				 {
		/* MyCart myCart = new MyCart();*/
			/*myCart.setUser_Id(user);*/
		
		 model.addAttribute("homePage",true);
		 model.addAttribute("userPage",true);
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String username = auth.getName(); //get logged in username
		 model.addAttribute("username",username);
			System.out.println("in user controller method");
			
			List<CategoryEntity> categoryList = adminService.getAllCategory();
			 List<Carousal> crdl=adminService.getCarousalproducts();
			 for(Carousal cpdl:crdl)
				 
			 {
				 model.addAttribute("carousalProduct", cpdl);
			 }
			 List<User> userDetail = userService.getUserByName(username);
			 
			 List<MyCart> cartItem1 = cartService.getCartItemById(userDetail.get(0).getId());
				int cNo= cartItem1.size();
				model.addAttribute("cNo",cNo);
				 model.addAttribute("UserName", username);
				  			  return new ModelAndView("index", "categoryList", categoryList);
		}
		
	}


		 
		 
