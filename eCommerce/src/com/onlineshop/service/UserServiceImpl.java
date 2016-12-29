package com.onlineshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.UserDAO;
import com.onlineshop.exception.UserException;
import com.onlineshop.pojo.User;
import com.onlineshop.vo.UserForm;

@Service
@Transactional
public class UserServiceImpl implements UserService {
     
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private AddressService addressService;
    
    public User getUser(String login) {
        return userDAO.getUser(login);
    }
    
    public void save(UserForm userForm) throws UserException {
    	
    	try {
    		User user = new User();
    		user.setFirstName(userForm.getFirstName());
    		user.setLastName(userForm.getLastName());
    		user.setEmail(userForm.getEmail());
    		user.setPhone(userForm.getPhone());
    		user.setFax(userForm.getFax());
    		user.setPassword(userForm.getPassword());
    		user.setEnabled("true");
    		userDAO.save(user);
			addressService.save(userForm.getAddressForm(), user);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("Unable to save user record :"+e.getMessage());
		}
    }
    
    public void saveShippingAddress(UserForm userForm) throws UserException {
    	try {
    		User user = userDAO.getUser(getPrincipal());
    		addressService.saveShippingAddress(userForm, user);
    	} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("Unable to save shipping address record :"+e.getMessage());
		}
    }
    
    public List<Object[]> getUserCartInfo(String email) throws UserException {
    	return userDAO.getUserCartInfo(email);
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
}