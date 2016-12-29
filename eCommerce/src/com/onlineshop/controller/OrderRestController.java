package com.onlineshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.service.EmailService;
import com.onlineshop.service.OrderService;

@Controller
public class OrderRestController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/confirmOrder/{cartItems}", method = RequestMethod.GET, produces="application/text")
	public ResponseEntity<String> confirmOrder(@PathVariable("cartItems") String cartItems,HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String email = getPrincipal();
			if(null!=email && !"anonymousUser".equalsIgnoreCase(email)) {
				orderService.confirmOrder(email, cartItems);
				// Delete the cart details of the user from the database
				orderService.removeCartDetails(email);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return new ResponseEntity<String>("orderSuccess", HttpStatus.OK);
	}
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	@RequestMapping(value = { "/orderSuccess", }, method = RequestMethod.GET)
	public ModelAndView redirectAfterOrderConfirm() {
		ModelAndView model = new ModelAndView();
		model.setViewName("orderSuccess");
		return model;

	}
}
