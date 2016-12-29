package com.onlineshop.service;

import com.onlineshop.exception.UserException;

public interface SecurityService {
	String findLoggedInUsername();
    void autologin(String username, String password) throws UserException;
}
