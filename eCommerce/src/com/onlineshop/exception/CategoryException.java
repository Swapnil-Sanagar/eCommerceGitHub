package com.onlineshop.exception;

public class CategoryException extends Exception {
	String message;

	public CategoryException(String message) {
		this.message = message;
	}

	public String toString() {
		return (message);
	}
}
