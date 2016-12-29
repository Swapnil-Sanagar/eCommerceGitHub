package com.onlineshop.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.onlineshop.exception.UserException;

@Service
public class EmailServiceImpl implements EmailService {
	public void sendEmail(String toEmailId, Long orderId) throws UserException {
		  // Recipient's email ID needs to be mentioned.
	      String to = toEmailId;

	      // Sender's email ID needs to be mentioned
	      String from = "swapnil.sangar89@gmail.com";//change accordingly
	      final String username = "swapnil.sangar89";//change accordingly
	      final String password = "9860617980";//change accordingly

	      // Assuming you are sending email from localhost
	      String host = "smtp.gmail.com";

	      // Get system properties
	      Properties properties = new Properties();
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.starttls.enable", "true");
	      properties.put("mail.smtp.host", host);
	      properties.put("mail.smtp.port", "587");

	      // Get the default Session object.
	   // Get the Session object.
	      Session session = Session.getInstance(properties,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Order Confirmation - Order ID :"+orderId);

	         // Now set the actual message
	         message.setText("Thank you for your purchase. We have received your payment for item '"
				+ orderId + "'. Best Ways Shop.");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
}
