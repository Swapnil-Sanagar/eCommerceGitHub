package com.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.AddressDAO;
import com.onlineshop.exception.AddressException;
import com.onlineshop.pojo.Address;
import com.onlineshop.pojo.ShippingAddress;
import com.onlineshop.pojo.User;
import com.onlineshop.vo.AddressForm;
import com.onlineshop.vo.UserForm;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;

	public Address save(AddressForm addressForm, User user) throws AddressException {
		try {
			Address address = new Address();
			address.setCompany(addressForm.getCompany());
			address.setCompanyId(addressForm.getCompanyId());
			address.setAddress1(addressForm.getAddress1());
			address.setAddress2(addressForm.getAddress2());
			address.setCity(addressForm.getCity());
			address.setCountry(addressForm.getCountry());
			address.setRegion(addressForm.getRegion());
			address.setZip(addressForm.getZip());
			address.setUser(user);
			addressDAO.save(address);
			return address;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddressException("Unable to save user address record :"
					+ e.getMessage());
		}
	}
	
	public ShippingAddress saveShippingAddress(UserForm userForm, User user) throws AddressException {
		try {
			ShippingAddress shippingAddress = null;
			if(null != userForm.getEmail() && !"".equals(userForm.getEmail())) {
				shippingAddress = addressDAO.getShippingAddress(userForm.getEmail());
			} 
			if(null == shippingAddress)
				shippingAddress = new ShippingAddress();
			shippingAddress.setFirstName(userForm.getFirstName());
			shippingAddress.setLastName(userForm.getLastName());
			shippingAddress.setEmail(userForm.getEmail());
			shippingAddress.setPhone(userForm.getPhone());
			shippingAddress.setAddress1(userForm.getAddressForm().getAddress1());
			shippingAddress.setAddress2(userForm.getAddressForm().getAddress2());
			shippingAddress.setCity(userForm.getAddressForm().getCity());
			shippingAddress.setCountry(userForm.getAddressForm().getCountry());
			shippingAddress.setRegion(userForm.getAddressForm().getRegion());
			shippingAddress.setZip(userForm.getAddressForm().getZip());
			shippingAddress.setShippingUser(user);
			addressDAO.saveShippingAddress(shippingAddress);
			return shippingAddress;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddressException("Unable to save shipping address record :"
					+ e.getMessage());
		}
	}
	
	public UserForm getShippingAddressInfo(String country, String region, String zipCode) throws AddressException {
		UserForm userForm = null;
		try {
			ShippingAddress shippingAddress = addressDAO.getShippingAddress(country,region,zipCode);
			if(null != shippingAddress) {
				userForm = new UserForm();
				userForm.setFirstName(shippingAddress.getFirstName());
				userForm.setLastName(shippingAddress.getLastName());
				userForm.setEmail(shippingAddress.getEmail());
				userForm.setPhone(shippingAddress.getPhone());
				AddressForm addressForm = new AddressForm();
				addressForm.setAddress1(shippingAddress.getAddress1());
				addressForm.setAddress2(shippingAddress.getAddress2());
				addressForm.setCity(shippingAddress.getCity());
				addressForm.setCountry(shippingAddress.getCountry());
				addressForm.setRegion(shippingAddress.getRegion());
				addressForm.setZip(shippingAddress.getZip());
				userForm.setAddressForm(addressForm);
			}
			return userForm;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddressException("Unable to fetch shipping address record :"
					+ e.getMessage());
		}
	}
}
