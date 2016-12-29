package com.onlineshop.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.exception.OrderException;
import com.onlineshop.pojo.Order;
import com.onlineshop.pojo.OrderDetails;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDAOImpl() {
    }
	
	public OrderDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Transactional
	public void confirmOrder(String email, String cartItems) throws OrderException {
		
	}
	
	@Transactional
	public void save(Order order) throws OrderException {
		try {
		sessionFactory.getCurrentSession().save(order);
		} catch(Exception e){
			throw new OrderException("Error while Save Order :"+e);
		}
	}
	
	@Transactional
	public void saveOrderDetails(OrderDetails orderDetails) throws OrderException {
		try {
			sessionFactory.getCurrentSession().save(orderDetails);
			} catch(Exception e){
				throw new OrderException("Error while Save Order Details :"+e);
			}
	}
}
