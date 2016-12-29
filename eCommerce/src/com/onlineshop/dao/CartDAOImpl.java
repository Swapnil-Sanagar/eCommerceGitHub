package com.onlineshop.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.exception.UserException;
import com.onlineshop.pojo.Cart;
import com.onlineshop.pojo.Product;
import com.onlineshop.pojo.User;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDAOImpl() {
    }
	
	public CartDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Transactional
	public void addToCart(String email, Map<String,String> productQuantityMap) throws UserException {
		try {
			User user = userDAO.getUser(email);
			for (Map.Entry<String,String> entry : productQuantityMap.entrySet()) {
				Product product = productDAO.get(Integer.parseInt(entry.getKey()));
				Cart cart = getCartItem(user.getUserId().toString(),product.getProductId().toString());
				if(null==cart) {
					cart = new Cart();
				}
				cart.setProduct(product);
				cart.setUser(user);
				cart.setQuantity(Integer.parseInt(entry.getValue()));
				cart.setDeleted("N");
				sessionFactory.getCurrentSession().saveOrUpdate(cart);
				System.out.println("Cart Details Added Successfully in Database.");
			}
		} catch(Exception e){
			throw new UserException(e.getMessage());
		}
	}
	
	public Cart getCartItem(String userId, String productId) throws UserException {
		try {
		 	String hql = "from Cart where deleted='N' and user.userId=" + userId +" and product.productId="+productId;
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
	         
	        List<Cart> listCart = (List<Cart>) query.list();
	         
	        if (listCart != null && !listCart.isEmpty()) {
	            return listCart.get(0);
	        }
	         
	        return null;
		} catch(Exception e){
			throw new UserException(e.getMessage());
		}
	}
	
	@Transactional
	public void deactivateCartItems(String email) throws UserException {
		try {
			User user = userDAO.getUser(email);
		 	String hql = "delete from cart where user_id='"+user.getUserId()+"'";
	        Query query = sessionFactory.getCurrentSession().createSQLQuery(hql);
	        Integer count = query.executeUpdate();
	        if(count > 0){
	        	System.out.println("Cart details removed successfully :"+count);
	        }
		} catch(Exception e){
			throw new UserException(e.getMessage());
		}
	}
}
