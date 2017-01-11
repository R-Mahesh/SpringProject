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

import com.model.entity.CartItem;
import com.model.entity.CategoryEntity;
import com.model.entity.MyCart;
import com.model.entity.Products;
import com.model.entity.User;
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
					
				
				
				
List<User> ur = userService.getAllUser();
		myCart.setUser_Id(userDetail.get(0));
		java.util.Date now = new java.util.Date();
		myCart.setDate_added(now);
		cartService.addCart(myCart);
		
		
prd = false;	
			}
			cNo=x.getCart_id();
		}
		if (prd) {
			List<User> ur = userService.getAllUser();
			
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
			List<User> ur = userService.getAllUser();
		
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

	return	"cartItemDisplay";
	}
	@RequestMapping("deleteCart")
	 public ModelAndView deleteCategory(@RequestParam int cartId,Model model) {
		cartService.deleteCart1(cartId);
		List<MyCart> cartItem1 = cartService.getAllCartItem();
		int cNo= cartItem1.size();
		model.addAttribute("cNo",cNo);
		  model.addAttribute("categoryPage",true);
	  return new ModelAndView("cartItemDisplay", "cartItem", cartItem1);
	 }

	@RequestMapping("checkOut")
	 public String addToCartItemTable(@RequestParam int grandTotal) {
		List<MyCart> cartItem1 = cartService.getAllCartItem();
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 		 String username = auth.getName();  //get logged in username
 		 List<User> userDetail = userService.getUserByName(username);
 		 CartItem cartItems = new CartItem();
 		cartItems.setCart_Items(cartItem1);
 		cartItems.setGrandTotal(grandTotal);
 		cartItems.setUser_id(userDetail.get(0));
 		cartService.addCarts(cartItems);
 		System.out.println(userDetail.get(0).getId());
 		List<MyCart> myc=cartService.getAllCartItem();
 		for(MyCart cl:myc)
 		{
 			cl.setCart_id(cl.getCart_id());
 		cl.setCartItem_Id(cartItems);
 		cartService.addCart(cl);
 		}
 		List<CartItem>  clst=cartService.getCartItem();
 		for(int i=0;clst.get(0).getCart_Items().size()>i;i++){
 			System.out.println(clst.get(0).getCart_Items().get(i).getProduct_id());
 			
 		}
 		List<MyCart> cartItem2 = cartService.getAllCartItem();
 		for(int i=0;cartItem2.size()>i;i++){
 		cartService.deleteCart(cartItem2.get(i).getCart_id());}
 		
		return "index";
	}
	
	
	
}
