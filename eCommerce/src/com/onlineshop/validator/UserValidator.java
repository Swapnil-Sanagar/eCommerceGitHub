package com.onlineshop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlineshop.pojo.User;
import com.onlineshop.service.UserService;
import com.onlineshop.vo.AddressForm;
import com.onlineshop.vo.LoginForm;
import com.onlineshop.vo.UserForm;

@Component
public class UserValidator implements Validator {
	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return User.class.equals(arg0);
	}
	
	public void validateLogin(Object arg0, Errors errors) {
		LoginForm loginForm = (LoginForm)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty","Please enter Email.");
		if (loginForm.getEmail().length() < 6 || loginForm.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email","Please enter email between 6 and 32 characters.");
        }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty","Please enter Password.");
        if (loginForm.getPassword().length() < 8 || loginForm.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password","Please enter password between 8 and 32 characters.");
        }
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		UserForm userForm = (UserForm)arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty","Please enter First Name.");
		if (userForm.getFirstName().length() < 6 || userForm.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.userForm.firstName","Please enter first name between 6 and 32 characters." );
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty","Please enter Last Name.");
		if (userForm.getLastName().length() < 6 || userForm.getLastName().length() > 32) {
            errors.rejectValue("lastName", "Size.userForm.lastName","Please enter last name between 6 and 32 characters.");
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty","Please enter Email.");
		if (userForm.getEmail().length() < 6 || userForm.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email","Please enter email between 6 and 32 characters.");
        }
		if (userService.getUser(userForm.getEmail()) != null) {
		    errors.rejectValue("email", "Duplicate.userForm.email","Email already exists.");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty","Please enter Phone Number.");
		if (userForm.getPhone().length() < 8 || userForm.getPhone().length() > 12) {
            errors.rejectValue("phone", "Size.userForm.phone","Please enter phone between 8 and 12 digits.");
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty","Please enter Password.");
        if (userForm.getPassword().length() < 8 || userForm.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password","Please enter password between 8 and 32 characters.");
        }

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm","Entered password doesn't match.");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.company", "NotEmpty","Please enter Company name.");
		if (userForm.getAddressForm().getCompany().length() < 6 || userForm.getAddressForm().getCompany().length() > 32) {
            errors.rejectValue("addressForm.company", "Size.userForm.addressForm.company","Please enter company between 6 and 32 characters.");
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.companyId", "NotEmpty","Please enter Company ID.");
		if (userForm.getAddressForm().getCompanyId().length() < 6 || userForm.getAddressForm().getCompanyId().length() > 32) {
            errors.rejectValue("addressForm.companyId", "Size.userForm.addressForm.companyId","Please enter company id between 6 and 32 characters.");
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.address1", "NotEmpty","Please enter ZIP code.");
		if (userForm.getAddressForm().getAddress1().length() < 6) {
            errors.rejectValue("addressForm.address1", "Size.userForm.addressForm.address1","Please enter address more than 6 characters.");
        }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.city", "NotEmpty","Please enter City.");
		if (userForm.getAddressForm().getCity().length() < 4 || userForm.getAddressForm().getCity().length() > 32) {
            errors.rejectValue("addressForm.city", "Size.userForm.addressForm.city","Please enter city between 4 and 32 characters.");
        }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.country", "NotEmpty","Please select Country.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.zip", "NotEmpty","Please enter ZIP code.");
		if (userForm.getAddressForm().getZip().length() < 6 || userForm.getAddressForm().getZip().length() > 10) {
            errors.rejectValue("addressForm.zip", "Size.userForm.addressForm.zip","Please enter ZIP code between 6 and 10 digits.");
        }
		if(userForm.getTerms() == null){
			errors.rejectValue("terms", "Size.userForm.terms","You must read and accept terms and conditions to register.");
		}
	}
	
	public void validateShippingAddress(Object arg0, Errors errors) {
		UserForm userForm = (UserForm)arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty","Please enter First Name.");
		if (userForm.getFirstName().length() < 6 || userForm.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.userForm.firstName","Please enter first name between 6 and 32 characters." );
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty","Please enter Last Name.");
		if (userForm.getLastName().length() < 6 || userForm.getLastName().length() > 32) {
            errors.rejectValue("lastName", "Size.userForm.lastName","Please enter last name between 6 and 32 characters.");
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty","Please enter Email.");
		if (userForm.getEmail().length() < 6 || userForm.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email","Please enter email between 6 and 32 characters.");
        }
		if (userService.getUser(userForm.getEmail()) != null) {
		    errors.rejectValue("email", "Duplicate.userForm.email","Email already exists.");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty","Please enter Phone Number.");
		if (userForm.getPhone().length() < 8 || userForm.getPhone().length() > 12) {
            errors.rejectValue("phone", "Size.userForm.phone","Please enter phone between 8 and 12 digits.");
        }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.address1", "NotEmpty","Please enter ZIP code.");
		if (userForm.getAddressForm().getAddress1().length() < 6) {
            errors.rejectValue("addressForm.address1", "Size.userForm.addressForm.address1","Please enter address more than 6 characters.");
        }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.city", "NotEmpty","Please enter City.");
		if (userForm.getAddressForm().getCity().length() < 4 || userForm.getAddressForm().getCity().length() > 32) {
            errors.rejectValue("addressForm.city", "Size.userForm.addressForm.city","Please enter city between 4 and 32 characters.");
        }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.country", "NotEmpty","Please select Country.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressForm.zip", "NotEmpty","Please enter ZIP code.");
		if (userForm.getAddressForm().getZip().length() < 6 || userForm.getAddressForm().getZip().length() > 10) {
            errors.rejectValue("addressForm.zip", "Size.userForm.addressForm.zip","Please enter ZIP code between 6 and 10 digits.");
        }
	}
	
	public void validateAddressInfoForm(Object arg0, Errors errors) {
		AddressForm addressForm = (AddressForm)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "NotEmpty","Please enter ZIP code.");
		if (addressForm.getZip().length() < 6 || addressForm.getZip().length() > 10) {
            errors.rejectValue("zip", "Size.addressForm.zip","Please enter ZIP code between 6 and 10 digits.");
        }
	}
}
