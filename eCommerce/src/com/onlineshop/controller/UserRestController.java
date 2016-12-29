package com.onlineshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.exception.AddressException;
import com.onlineshop.exception.UserException;
import com.onlineshop.service.AddressService;
import com.onlineshop.service.CartService;
import com.onlineshop.service.SecurityService;
import com.onlineshop.service.UserService;
import com.onlineshop.validator.UserValidator;
import com.onlineshop.vo.AddressForm;
import com.onlineshop.vo.LoginForm;
import com.onlineshop.vo.LogoutForm;
import com.onlineshop.vo.UserForm;

@Controller
public class UserRestController {
	
	@Autowired
	private UserValidator userValidator;
	 
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/getCartDetails",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<Object[]>>  getCartDetails(){
		List<Object[]> cartDetails = new ArrayList<Object[]>();
		try {
			String email = getPrincipal();
			if(null!=email && !"anonymousUser".equalsIgnoreCase(email)) {
				cartDetails = userService.getUserCartInfo(email);
			}
		} catch (UserException e){
			e.printStackTrace();
			return null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return new ResponseEntity<List<Object[]>>(cartDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addCartItems/{cartItems}",method=RequestMethod.GET,produces="application/json")
	public void addCartItems(@PathVariable("cartItems") String cartItems,HttpServletRequest request,
			HttpServletResponse response){
		try {

			String email = getPrincipal();
			if(null!=email && !"anonymousUser".equalsIgnoreCase(email)) {
				cartService.addToCart(getPrincipal(),cartItems);
			}
		} catch (UserException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		//return "redirect:/";

	}
	
	@RequestMapping(value = { "/", "/home**" }, method = RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = { "/loginSuccess", }, method = RequestMethod.GET)
	public ModelAndView redirectAfterSuccessLogin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("afterLogin","true");
		return model;

	}
	
	/*@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "home";
	}*/

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cartPage(ModelMap model) {
		model.addAttribute("userForm", new UserForm());
		model.addAttribute("addressForm",new AddressForm());
		return "cart";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
	public String loginPage(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult,Model model, 
			@RequestParam(value = "error",required = false) String error,
			@RequestParam(value = "logout",	required = false) String logout) {
		try {
			//userValidator.validateLogin(loginForm, bindingResult);
			if (bindingResult.hasErrors()) {
		         return "login";
		      }
			
			if (error != null) {
				model.addAttribute("errorLogin", "Invalid Credentials provided.");
			}
			model.addAttribute("login", loginForm);
		} catch(Exception e){
			model.addAttribute("failureMessage", "Error occured in your login, please try again !!!");
			return "login";
		}
		return "login";
	}
	
	/*@RequestMapping(value = "/processLogin.htm", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public String processLogin(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model) {
		System.out.println();
		return "login";
	}*/

	@RequestMapping(value = "logout", method = {RequestMethod.POST,RequestMethod.GET})
	public String logoutPage(@ModelAttribute("logoutForm") LogoutForm logoutForm,
			HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		try {
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		} catch(Exception e) {
			
		}
		return "redirect:/login?logout";
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
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
	    UserForm userForm = new UserForm();
	    model.addAttribute("userForm", userForm);
	    return "register";
	}
	
	@RequestMapping(value = "registerUser.htm", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public String register(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) { 
		try {
			 userValidator.validate(userForm, bindingResult);
			  if (bindingResult.hasErrors()) {
		         return "register";
		      }
			  userService.save(userForm);
			  securityService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());
			  cartService.addToCart(userForm.getEmail(),userForm.getCartItems());
			  return "redirect:/home";
		} catch(UserException e){
			model.addAttribute("failureMessage", "Error occured in your registration, please try again !!!");
			return "register";
		} catch(Exception e){
			model.addAttribute("failureMessage", "Error occured in your registration, please try again !!!");
			return "register";
		}
	}
	
	@RequestMapping(value = "addShippingAddress.htm", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public String addShippingAddress(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) { 
		try {
			userValidator.validateShippingAddress(userForm, bindingResult);
			if (bindingResult.hasErrors()) {
		         return "cart";
		    }
			userService.saveShippingAddress(userForm);
			model.addAttribute("successMessage", "Shipping Address information added successfully.");
			model.addAttribute("addressForm",new AddressForm());
			return "cart";
		} catch(UserException e){
			model.addAttribute("failureMessage", "Error occured in adding shipping address, please try again !!!");
			return "cart";
		} catch(Exception e){
			model.addAttribute("failureMessage", "Error occured in adding shipping address, please try again !!!");
			return "cart";
		}
	}
	
	@RequestMapping(value = "getAddressInfo.htm", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public String getAddressInfo(@ModelAttribute("addressForm") AddressForm addressForm, BindingResult bindingResult, Model model) { 
		try {
			UserForm userForm = new UserForm();
			userValidator.validateAddressInfoForm(addressForm, bindingResult);
			if (bindingResult.hasErrors()) {
				model.addAttribute("userForm",userForm);
		        return "cart";
		    }
			userForm = addressService.getShippingAddressInfo(addressForm.getCountry(), addressForm.getRegion(), addressForm.getZip());
			if(null==userForm) {
				model.addAttribute("addressFailureMessage", "Unable to fetch address information.");
				model.addAttribute("userForm",new UserForm());
			}
			else
				model.addAttribute("userForm",userForm);
			
			model.addAttribute("addressForm",new AddressForm());
			return "cart";
		} catch(AddressException e){
			model.addAttribute("failureMessage", "Error occured in fetching shipping address, please try again !!!");
			return "cart";
		} catch(Exception e){
			model.addAttribute("failureMessage", "Error occured in fetching shipping address, please try again !!!");
			return "cart";
		}
	}
}
