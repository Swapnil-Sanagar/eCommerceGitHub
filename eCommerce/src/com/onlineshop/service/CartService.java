package com.onlineshop.service;

import com.onlineshop.exception.UserException;

public interface CartService {
	public void addToCart(String email, String cartItems) throws UserException;
	public void deactivateCartItems(String email) throws UserException;
}
