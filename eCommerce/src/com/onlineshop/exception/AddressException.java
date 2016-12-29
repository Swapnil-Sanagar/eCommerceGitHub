package com.onlineshop.exception;

public class AddressException extends Exception {
	String message;

	public AddressException(String message) {
		this.message = message;
	}

	public String toString() {
		return (message);
	}
}
