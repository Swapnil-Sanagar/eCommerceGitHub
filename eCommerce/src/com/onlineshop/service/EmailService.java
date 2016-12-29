package com.onlineshop.service;

import com.onlineshop.exception.UserException;

public interface EmailService {
	public void sendEmail(String toEmailId, Long orderId) throws UserException;
}
