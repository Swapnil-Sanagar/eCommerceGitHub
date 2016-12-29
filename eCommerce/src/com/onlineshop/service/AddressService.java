package com.onlineshop.service;

import com.onlineshop.exception.AddressException;
import com.onlineshop.pojo.Address;
import com.onlineshop.pojo.ShippingAddress;
import com.onlineshop.pojo.User;
import com.onlineshop.vo.AddressForm;
import com.onlineshop.vo.UserForm;

public interface AddressService {
	public Address save(AddressForm addressForm, User user) throws AddressException;
	public ShippingAddress saveShippingAddress(UserForm userForm, User user) throws AddressException;
	public UserForm getShippingAddressInfo(String country, String region, String zipCode) throws AddressException;
}
