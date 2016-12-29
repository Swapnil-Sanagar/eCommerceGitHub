package com.onlineshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshop.pojo.UserRole;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {
	@Autowired
    private SessionFactory sessionFactory;
     
    public UserRole getUserRole(String role) {
    	List<UserRole> userRoleList = new ArrayList<UserRole>();
    	Query query = sessionFactory.getCurrentSession().createQuery(
		"from UserRole u where u.role = :role");
    	query.setParameter("role", role);
    	userRoleList = query.list();
    	if (userRoleList.size() > 0)
			return userRoleList.get(0);
		else
			return null;
    }
    
    public void saveUserRole(UserRole userRole){
    	sessionFactory.getCurrentSession().save(userRole);
    }
}
