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
	public User bindUser() {
		return new User();
	}

	@ModelAttribute("myCart")
	public MyCart bindCart() {
		return new MyCart();
	}

	@RequestMapping("/details")
	public ModelAndView detailPage(@RequestParam("id") int productId, Model modal) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get logged in username
		Products productDetail = productService.getProducts(productId);
		List userDetail = userService.getUserByName(username);
		System.out.println(username);
		modal.addAttribute("productDetail", productDetail);
		modal.addAttribute("userDetail", userDetail);
		return new ModelAndView("details");

	}

	@RequestMapping(value = "/addToCart")
	public ModelAndView saveRecord(@ModelAttribute("myCart") MyCart myCart, Model modal) {
		/*
		 * Products productDetail =
		 * productService.getProducts(myCart.getProduct_id());
		 */
		
		boolean prd = true;
		List<MyCart> cartItem = cartService.getAllCartItem();
		for (MyCart x : cartItem) {
			if ((myCart.getProduct_id() == (x.getProduct_id()))) {
				int cr = x.getCart_id();
				myCart.setCart_id(cr);
				int y = x.getQuantity();
				
				y = y + 1;
				
				
				myCart.setQuantity(y);
				
				int z = x.getPrice();
				
				z=y*z;
				
				myCart.setPrice(z);
			
				
				
				
					User UserDetails = userService.getUser(Integer.parseInt(myCart.getUser_id()));
				myCart.setUser_Id(UserDetails);

				java.util.Date now = new java.util.Date();
				myCart.setDate_added(now);
				cartService.addCart(myCart);
				prd = false;
				break;
			}

		}
		if (prd) {
			User UserDetails = userService.getUser(Integer.parseInt(myCart.getUser_id()));
			myCart.setUser_Id(UserDetails);
			java.util.Date now = new java.util.Date();
			myCart.setDate_added(now);
			cartService.addCart(myCart);

		}
		if (cartService.getAllCartItem().isEmpty()) {
			User UserDetails = userService.getUser(Integer.parseInt(myCart.getUser_id()));
			myCart.setUser_Id(UserDetails);
			java.util.Date now = new java.util.Date();
			myCart.setDate_added(now);
			cartService.addCart(myCart);
		}
		List<MyCart> cartItem1 = cartService.getAllCartItem();
modal.addAttribute("cartItem",cartItem1);
		return new ModelAndView("cartItemDisplay");
	}

}
