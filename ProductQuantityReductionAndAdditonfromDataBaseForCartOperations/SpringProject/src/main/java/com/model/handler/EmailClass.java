package com.model.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailClass {

	@Autowired
	MailSender mailsend;
	public void mailmethod(String toAddress, String fromAddress, String subject, String msgBody){
		SimpleMailMessage msgdetails = new SimpleMailMessage();
		msgdetails.setFrom(fromAddress);
		msgdetails.setTo(toAddress);
		msgdetails.setSubject(subject);
		msgdetails.setText(msgBody);
		mailsend.send(msgdetails);

}
	
}
