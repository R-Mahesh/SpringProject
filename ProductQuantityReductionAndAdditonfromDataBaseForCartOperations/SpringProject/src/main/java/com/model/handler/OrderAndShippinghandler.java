package com.model.handler;


import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.model.entity.CartItem;
import com.model.entity.MyCart;
import com.model.entity.Orders;
import com.model.entity.ShipmentDetail;
import com.model.entity.User;
import com.model.service.CartService;
import com.model.service.OrderAndShippingService;
import com.model.service.UserService;

@Component
public class OrderAndShippinghandler {

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	@Autowired
	OrderAndShippingService orderAndShippingService;
	
	 @Autowired
		EmailClass mailtouser; 
	
	
	public ShipmentDetail initFlow(){
		return new ShipmentDetail();
	}	
	
	public String checkDetails(ShipmentDetail shipmentDetail,MessageContext messageContext){
		
		
		String status = "success";
		if(shipmentDetail.getName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"name").defaultText("name cannot be Empty").build());
			status = "failure";
		}
		if( shipmentDetail.getPhoneNumber()==0){
			messageContext.addMessage(new MessageBuilder().error().source(
					"phoneNumber").defaultText("phoneNumber cannot be Empty").build());
			status = "failure";
		}
		if(shipmentDetail.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("address cannot be Empty").build());
			status = "failure";
		}
		
			
		return status;
	}
	public String saveDetail(ShipmentDetail shipmentDetail)
	{
		
		long grandTotal=0;
		List<MyCart> cartItem2 = cartService.getAllCartItem();
		for (MyCart x : cartItem2) { 
		grandTotal=grandTotal+x.getTotalPrice();
		}
	
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
		List<MyCart> cartItem3 = cartService.getCartItemById(userDetail.get(0).getId());
		for(int i=0;cartItem3.size()>i;i++){
		cartService.deleteCart(cartItem3.get(i).getCart_id());}
	
	
		
		shipmentDetail.setCart_id(cartItems);
		orderAndShippingService.addSupplier(shipmentDetail);
		Orders orders = new Orders();
		orders.setCart_Id(cartItems);
		orders.setShipmentDetail(shipmentDetail);
		orders.setUser_Id(userDetail.get(0));
		orderAndShippingService.addOrderDetails(orders);
		userDetail.get(0).setId(userDetail.get(0).getId());
		userDetail.get(0).setCart_id(cartItems);
		userService.addUser(userDetail.get(0));
		
		
		/*MimeBodyPart imagePart = new MimeBodyPart();

		try {
			imagePart.attachFile("resources/images/google-plus-download.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		  MimeMultipart content = new MimeMultipart();


		try {
			content.addBodyPart(imagePart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
*/
		
		String toAddr = userDetail.get(0).getUserEmail();
		String fromAddr = "maheshravi9515@gmail.com";
 
		// email subject
		String subject =  "HotElectronAppliences Purchase Details";
 
		// email body
		String body = "your order id is"+"  "+ orders.getOrder_Id()+"  "+"you will receive your purchased product shortly";
		mailtouser.mailmethod(toAddr, fromAddr, subject, body);
		
		

		
		
		return "success";
	}
	
}
