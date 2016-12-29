package com.onlineshop.service;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.OrderDAO;
import com.onlineshop.dao.ProductDAO;
import com.onlineshop.dao.UserDAO;
import com.onlineshop.exception.OrderException;
import com.onlineshop.pojo.Order;
import com.onlineshop.pojo.OrderDetails;
import com.onlineshop.pojo.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderDAO orderDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	EmailService emailService;
	
	public void confirmOrder(String email, String cartItems) throws OrderException {
		
		try {
			Order order = new Order();
			User user = userDAO.getUser(email);
			order.setOrderDate(new Date());
			order.setTransactionStatus("Success");
			order.setDeleted("N");
			order.setUser(user);
			orderDAO.save(order);
			if(order.getOrderId() != null) {
				System.out.println("Order Inserted Successfully");
				JSONArray jsonArray = new JSONArray(cartItems);
				for(int i=0; i<jsonArray.length();i++){
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					//{"_quantity":20,"_id":1,"_name":"Flower Name1","_price":600},
					String id = jsonObject.get("_id").toString();
					String quantity = null != jsonObject.get("_price") ? jsonObject.get("_quantity").toString() : "0";
					String price = null != jsonObject.get("_price") ? jsonObject.get("_price").toString() : "0";
					
					OrderDetails orderDetails = new OrderDetails();
					//orderDetails.setBillingDate(new Date());
					orderDetails.setOrder(order);
					orderDetails.setPrice(Double.parseDouble(price));
					orderDetails.setProduct(productDAO.get(Integer.parseInt(id)));
					orderDetails.setQuantity(Long.parseLong(quantity));
					orderDAO.saveOrderDetails(orderDetails);
				}
				//Send SMS after order confirmation
				emailService.sendEmail(user.getEmail(), order.getOrderId());
			}
		} catch(Exception e){
			throw new OrderException("Error while confirm order:"+e);
		}
	}
	
	public void removeCartDetails(String email) throws OrderException {
		try {
			cartService.deactivateCartItems(email);
		} catch(Exception e){
			throw new OrderException("Error while removing cart details of "+email+" "+e);
		}
	}
}
