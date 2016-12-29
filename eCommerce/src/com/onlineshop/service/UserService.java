package com.onlineshop.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.onlineshop.exception.UserException;
import com.onlineshop.pojo.User;
import com.onlineshop.vo.UserForm;

@Component
public interface UserService {
	public User getUser(String login);
	public void save(UserForm userForm) throws UserException;
	public List<Object[]> getUserCartInfo(String email) throws UserException;
	public void saveShippingAddress(UserForm userForm) throws UserException;
}
