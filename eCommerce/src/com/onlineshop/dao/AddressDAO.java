package com.onlineshop.dao;

import com.onlineshop.exception.AddressException;
import com.onlineshop.pojo.Address;
import com.onlineshop.pojo.ShippingAddress;

public interface AddressDAO {
	
	public ShippingAddress getShippingAddress(String login) throws AddressException;

	public void save(Address address);

	public void saveShippingAddress(ShippingAddress shippingAddress);

	public ShippingAddress getShippingAddress(String country, String region,
			String zipCode) throws AddressException;
}
