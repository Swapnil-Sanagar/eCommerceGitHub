package com.onlineshop.vo;

public class UserForm {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String fax;
	private String password;
	private String passwordConfirm;
	private AddressForm addressForm;
	private String terms;
	private String cartItems;
	private String totalCost;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public AddressForm getAddressForm() {
		return addressForm;
	}

	public void setAddressForm(AddressForm addressForm) {
		this.addressForm = addressForm;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getCartItems() {
		return cartItems;
	}

	public void setCartItems(String cartItems) {
		this.cartItems = cartItems;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
