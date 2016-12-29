package com.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.onlineshop.exception.UserException;

@Service
public class SecurityServiceImpl implements SecurityService {
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }
	
	@Override
    public void autologin(String username, String password) throws UserException{
		try {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
	
	        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	
	        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            System.out.println(String.format("Auto login %s successfully!", username));
	        }
		}
		catch(Exception e){
			throw new UserException(e.getMessage());
		}
    }
}
