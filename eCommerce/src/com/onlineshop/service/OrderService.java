package com.onlineshop.service;

import com.onlineshop.exception.OrderException;

public interface OrderService {
	public void confirmOrder(String email, String cartItems) throws OrderException;
	public void removeCartDetails(String email) throws OrderException;
}
