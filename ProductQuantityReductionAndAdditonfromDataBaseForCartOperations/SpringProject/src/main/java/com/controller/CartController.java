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

import com.model.entity.CategoryEntity;
import com.model.entity.MyCart;
import com.model.entity.Products;
import com.model.entity.User;
import com.model.service.AdminService;
import com.model.service.CartService;
import com.model.service.ProductService;
import com.model.service.UserService;

@Controller
public class CartController {
	 static int cNo;
	 
	 static boolean productExist;
	 
	 /*static long grandTotal=0;*/
	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	 @Autowired
	 private AdminService adminService;
	
	@ModelAttribute("user")
	public User bindUser() {
		return new User();
	}

	@ModelAttribute("myCart")
	public MyCart bindCart() {
		return new MyCart();
	}

	@RequestMapping("/details")
	public ModelAndView detailPage(@RequestParam("id") int productId, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get logged in username
		/*Products productDetail = productService.getProducts(productId);*/
		List<User> userDetail = userService.getUserByName(username);
		System.out.println(username);
		 List<Products> prdl=productService.getAllProducts();
		 for(Products pdl:prdl)
		 {if(pdl.getId()==productId)
			 
		 {
			 model.addAttribute("productDetail", pdl);
			 break;
		 }
		 
		 }
		model.addAttribute("userDetail", userDetail);
		return new ModelAndView("details");

	}

	@RequestMapping(value = "/addToCart")
	public ModelAndView saveRecord(@ModelAttribute("myCart") MyCart myCart, Model modal) {
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 		 String username = auth.getName();
 		 List<User> userDetail = userService.getUserByName(username);
		productExist=true;
		List<Products> pdrlst=productService.getAllProducts();
		for(Products plst:pdrlst)
		{
			if ((myCart.getProduct_id() == (plst.getId())))
			
			{
				int Qnty=plst.getQuantity();
				if(Qnty==0)
				{
					productExist=false;
					break;
				}
				break;
			}
		}	
		
		if(productExist){
		boolean prd = true;
		List<MyCart> cartItem = cartService.getCartItemById(userDetail.get(0).getId());
		
		for (MyCart x : cartItem) {
			if ((myCart.getProduct_id() == (x.getProduct_id()))) {
				int cartId = x.getCart_id();
				cNo=cartId;
				if(true){}
				myCart.setCart_id(cartId);
				int quantity = x.getQuantity();
				
				
				
				
				for(Products plst:pdrlst)
				{
					if ((myCart.getProduct_id() == (plst.getId())))
					
					{
						int Qnty=plst.getQuantity()-1;
						plst.setQuantity(Qnty);
						plst.setId(plst.getId());
						productService.editProducts(plst);
						break;
					}
					
				}	
					
					
				
				quantity  = quantity  + 1;
				
				
				myCart.setQuantity(quantity );
				
				int price = x.getPrice();
				
				int totalPrice=quantity *price;
				
				myCart.setTotalPrice(totalPrice);
					
				
				
				
		myCart.setUser_Id(userDetail.get(0));
		java.util.Date now = new java.util.Date();
		myCart.setDate_added(now);
		cartService.addCart(myCart);
		
		
prd = false;	
			}
			cNo=x.getCart_id();
		}
		if (prd) {
			
			myCart.setUser_Id(userDetail.get(0));
					java.util.Date now = new java.util.Date();
					myCart.setDate_added(now);
					cartService.addCart(myCart);
				
						
			
			for(Products plst:pdrlst)
			{
				if ((myCart.getProduct_id() == (plst.getId())))
				
				{
					int Qnty=plst.getQuantity()-1;
					plst.setQuantity(Qnty);
					plst.setId(plst.getId());
					productService.editProducts(plst);
					break;
				}
				
			}
			
		}
		if (cartService.getAllCartItem().isEmpty()) {
		
					myCart.setUser_Id(userDetail.get(0));
					java.util.Date now = new java.util.Date();
					myCart.setDate_added(now);
					cartService.addCart(myCart);
				
			for(Products plst:pdrlst)
			{
				if ((myCart.getProduct_id() == (plst.getId())))
				
				{
					int Qnty=plst.getQuantity()-1;
					plst.setQuantity(Qnty);
					plst.setId(plst.getId());
					productService.editProducts(plst);
					break;
				}
				
			}
		}
		
		List<MyCart> cartItem1 = cartService.getCartItemById(userDetail.get(0).getId());
		int cNo= cartItem1.size();
modal.addAttribute("cartItem",cartItem1);
modal.addAttribute("cNo",cNo);
long grandTotal=0;
for (MyCart x1 : cartItem1) {
	
	grandTotal=grandTotal+x1.getTotalPrice();
	
}

		return new ModelAndView("cartItemDisplay","grandTotal",grandTotal);}
		
		else{return new ModelAndView("details","productEmpt","sorry product is soldOut");}
	}

	@RequestMapping("cartItemDisplay")
	public String cartItemDisplay(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get logged in username
		/*Products productDetail = productService.getProducts(productId);*/
		List<User> userDetail = userService.getUserByName(username);
	
		
		long grandTotal=0;
		List<MyCart> cartItem1 = cartService.getCartItemById(userDetail.get(0).getId());
		int cNo= cartItem1.size();
		model.addAttribute("cartItem",cartItem1);
		for (MyCart x : cartItem1) { 
		grandTotal=grandTotal+x.getTotalPrice();
		}
	
		model.addAttribute("grandTotal",grandTotal);
		model.addAttribute("cNo",cNo);
	
	model.addAttribute("grandTotal",grandTotal);
	  List<CategoryEntity> categoryList = adminService.getAllCategory();
	  model.addAttribute("categoryList",categoryList);
	  model.addAttribute("UserName", username);
	return	"cartItemDisplay";
	}
	@RequestMapping("deleteCart")
	 public ModelAndView deleteCategory(@RequestParam int cartId,Model model) {
		 
		
		List<MyCart> cartItem=cartService.getAllCartItem();
		 for(MyCart crt:cartItem){
			
		if(crt.getCart_id()==cartId)
		{   
			 List<Products> productUpd= productService.getAllProducts();
			 for(Products prt:productUpd){
		if(prt.getId()==crt.getProduct_id())
		{
			
			prt.setId(prt.getId());
			prt.setQuantity(prt.getQuantity()+crt.getQuantity());
			
			 productService.editProducts(prt);
			 }
			 }
		}	
		 }
		 
		
		
		cartService.deleteCart1(cartId);
		
		
		
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get logged in username
		List<User> userDetail = userService.getUserByName(username);
		List<MyCart> cartItem1 = cartService.getCartItemById(userDetail.get(0).getId());
		int cNo= cartItem1.size();
		model.addAttribute("cNo",cNo);
		long grandTotal=0;
		for (MyCart x1 : cartItem1) {
			
			grandTotal=grandTotal+x1.getTotalPrice();
			
		}

		model.addAttribute("grandTotal",grandTotal);
		  model.addAttribute("categoryPage",true);
		  model.addAttribute("UserName", username);
	  return new ModelAndView("cartItemDisplay", "cartItem", cartItem1);
	 }

		
	
	
}
