package com.onlineshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineshop.exception.AddressException;
import com.onlineshop.pojo.Address;
import com.onlineshop.pojo.ShippingAddress;
import com.onlineshop.pojo.User;

@Repository
public class AddressDAOImpl implements AddressDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public AddressDAOImpl() {
	}

	public AddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Address address) {
		sessionFactory.getCurrentSession().saveOrUpdate(address);
	}
	
	public void saveShippingAddress(ShippingAddress shippingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
	}
	
	public ShippingAddress getShippingAddress(String country, String region, String zipCode) throws AddressException {
		ShippingAddress shippingAddress = null;
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("from ShippingAddress s where s.zip=:zip ");
			if(null!=country && !"".equalsIgnoreCase(country))
				stringBuilder.append("and s.country = '"+country+"'");
			if(null!=region && !"".equalsIgnoreCase(region))
				stringBuilder.append("and s.region = :'"+region+"'");
			
			Query query = sessionFactory.getCurrentSession().createQuery(stringBuilder.toString());
			query.setParameter("zip", zipCode);
			List<ShippingAddress> shippingAddresses = query.list();
			if(null!=shippingAddresses && shippingAddresses.size() > 0)
				shippingAddress = shippingAddresses.get(0);
		} catch(Exception e){
			throw new AddressException(e.getMessage());
		}
		return shippingAddress;
	}
	
	public ShippingAddress getShippingAddress(String email) throws AddressException {
		List<ShippingAddress> shippingAddresses = new ArrayList<ShippingAddress>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from ShippingAddress s where s.email = :email");
		query.setParameter("email", email);
		shippingAddresses = query.list();
		if (shippingAddresses.size() > 0)
			return shippingAddresses.get(0);
		else
			return null;
	}
}
