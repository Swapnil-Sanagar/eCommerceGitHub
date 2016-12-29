package com.onlineshop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.UserDAO;
import com.onlineshop.pojo.UserRole;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
    private UserDAO userDAO;  
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.onlineshop.pojo.User userDO = userDAO.getUser(email);
		
		boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
		return new User(
				userDO.getEmail(), 
				userDO.getPassword(), 
                enabled, 
                accountNonExpired, 
                credentialsNonExpired, 
                accountNonLocked,
                getAuthorities(userDO.getUserRoles())
        );
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(List<UserRole> userRoleList) {
        List<GrantedAuthority> authList = getGrantedAuthorities(userRoleList);
        return authList;
    }
	
	public List<String> getRoles(Integer role) {
		 
        List<String> roles = new ArrayList<String>();
 
        if (role.intValue() == 1) {
            roles.add("ROLE_MODERATOR");
            roles.add("ROLE_ADMIN");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_MODERATOR");
        }
        return roles;
    }
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<UserRole> userRoleList) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for (int i=0; i<userRoleList.size(); i++) {
            authorities.add(new SimpleGrantedAuthority(userRoleList.get(i).getRole()));
        }
        return authorities;
    }
}
