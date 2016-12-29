package com.onlineshop.exception;

public class OrderException extends Exception {
	String message;

	public OrderException(String message) {
		this.message = message;
	}

	public String toString() {
		return (message);
	}
}
