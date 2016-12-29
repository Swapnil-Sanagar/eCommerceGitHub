package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.exception.UserException;
import com.onlineshop.pojo.User;

public interface UserDAO {
	public User getUser(String login);

	public void save(User user) throws UserException;

	public List<Object[]> getUserCartInfo(String email)
			throws UserException;
}
