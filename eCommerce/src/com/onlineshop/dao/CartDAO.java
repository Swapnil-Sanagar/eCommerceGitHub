package com.onlineshop.dao;

import java.util.Map;

import com.onlineshop.exception.UserException;
import com.onlineshop.pojo.Cart;

public interface CartDAO {
	public void addToCart(String email, Map<String,String> productQuantityMap) throws UserException;
	public Cart getCartItem(String userId, String productId) throws UserException;
	public void deactivateCartItems(String email) throws UserException;
}
