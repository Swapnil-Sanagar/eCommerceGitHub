package com.onlineshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.onlineshop.exception.UserException;
import com.onlineshop.pojo.User;
import com.onlineshop.pojo.UserRole;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    @Autowired
    private UserRoleDAO userRoleDAO;

	public UserDAOImpl() {
	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUser(String email)  {
		List<User> userList = new ArrayList<User>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User u where u.email = :email");
		query.setParameter("email", email);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	@Override
	public void save(User user) throws UserException {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			sessionFactory.getCurrentSession().save(user);
			
			UserRole userRole = new UserRole();
			userRole.setRole("ROLE_USER");
			userRole.setRoleUser(user);
			userRoleDAO.saveUserRole(userRole);
		} catch(Exception e){
			throw new UserException(e.getMessage());
		}
	}
	
	public List<Object[]> getUserCartInfo(String email) throws UserException {
		List<Object[]> userCartInfo = new ArrayList<Object[]>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
			"select product.productId, product.unitPrice, product.productName, quantity from Cart c where c.user.email = :email and deleted='N'");
			query.setParameter("email", email);
			userCartInfo = query.list();
			
		}catch(Exception e){
			throw new UserException(e.getMessage());
		}
		return userCartInfo;
	}
}
