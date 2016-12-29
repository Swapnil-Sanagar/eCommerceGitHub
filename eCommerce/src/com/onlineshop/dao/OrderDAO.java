package com.onlineshop.dao;

import com.onlineshop.exception.OrderException;
import com.onlineshop.pojo.Order;
import com.onlineshop.pojo.OrderDetails;

public interface OrderDAO {
	public void confirmOrder(String email, String cartItems) throws OrderException;
	public void save(Order order) throws OrderException;
	public void saveOrderDetails(OrderDetails orderDetails) throws OrderException;
}
