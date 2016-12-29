package com.onlineshop.vo;

public class LogoutForm {
	private String csrfParameterName;
	private String cartItems;

	public String getCsrfParameterName() {
		return csrfParameterName;
	}

	public void setCsrfParameterName(String csrfParameterName) {
		this.csrfParameterName = csrfParameterName;
	}

	public String getCartItems() {
		return cartItems;
	}

	public void setCartItems(String cartItems) {
		this.cartItems = cartItems;
	}

}
