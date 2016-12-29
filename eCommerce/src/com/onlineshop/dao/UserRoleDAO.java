package com.onlineshop.dao;

import com.onlineshop.pojo.UserRole;

public interface UserRoleDAO {
	 public UserRole getUserRole(String role);
	 public void saveUserRole(UserRole userRole);
}
