package com.onlineshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.CartDAO;
import com.onlineshop.exception.UserException;
import com.onlineshop.pojo.Cart;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	CartDAO cartDAO;
	
	public void addToCart(String email, String cartItems) throws UserException{
		//Map<String,String> cartProductInfo = new HashMap<String, String>();
		try {
			
			//[{"_id":"1","_name":"Flowers","_price":600,"_quantity":4}]
			JSONArray jsonArray = new JSONArray(cartItems);
			Map<String, String> productQuantityMap = new HashMap<String, String>();
			for(int i=0; i<jsonArray.length();i++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String productId = jsonObject.get("_id").toString();
				String productQuantity = jsonObject.get("_quantity").toString();
				productQuantityMap.put(productId, productQuantity);
				//Double productPriceFromDB = productService.getProductPriceById(productId);
				//cartProductInfo.put(productId, productQuantity+"-"+productPriceFromDB);
			}
			cartDAO.addToCart(email,productQuantityMap);
			System.out.println("Cart Info Added Successfully.");
		} catch(Exception e){
			throw new UserException(e.getMessage());
		}
		//return cartProductInfo;
	}
	
	public void deactivateCartItems(String email) throws UserException {
		try {
			cartDAO.deactivateCartItems(email);
		} catch(Exception e){
			throw new UserException(e.getMessage());
		}
	}
}
