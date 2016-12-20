package com.model.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.model.entity.*;
import com.model.service.UserService;
@Component
public class Demohandler {
	

	 @Autowired
	 private UserService userService;
	
	public User initFlow(){
		return new User();
	}	
 
	public String validateDetails(User user,MessageContext messageContext){
		String status = "success";
		if(user.getUserName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"userName").defaultText("userName cannot be Empty").build());
			status = "failure";
		}
		if(user.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("password cannot be Empty").build());
			status = "failure";
		}
		if(user.getConfirmPassWord().isEmpty()){
		
			messageContext.addMessage(new MessageBuilder().error().source(
					"confirmPassWord").defaultText("confirmPassWord cannot be Empty").build());
			status = "failure";
		}
		if((user.getConfirmPassWord().equals(user.getPassword()))== false){
			
			messageContext.addMessage(new MessageBuilder().error().source(
					"confirmPassWord").defaultText("Password Mismatch").build());
			status = "failure";
		}
		return status;
	}
	
	public String registerUser(User user)
	{
                                 
		User_authorization athz = new User_authorization();
		athz.setRole("ROLE_USER");
		athz.setId_fk(user);
		user.setEnabled(true);
		
		userService.addUser(user);
		userService.addAuth(athz);
		return "success";
	}
	
}
