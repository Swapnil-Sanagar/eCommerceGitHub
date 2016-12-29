package com.onlineshop.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_address")
public class ShippingAddress implements java.io.Serializable {

	private Long shppingAddressId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String country;
	private String region;
	private User shippingUser;

	public ShippingAddress() {

	}

	public ShippingAddress(Long shppingAddressId, String firstName,
			String lastName, String email, String phone, String address1,
			String address2, String city, String zip, String country,
			String region) {
		super();
		this.shppingAddressId = shppingAddressId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.region = region;
	}
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ship_address_id")
	public Long getShppingAddressId() {
		return shppingAddressId;
	}

	public void setShppingAddressId(Long shppingAddressId) {
		this.shppingAddressId = shppingAddressId;
	}
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "user_name")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name = "region")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_user_id")
	public User getShippingUser() {
		return shippingUser;
	}

	public void setShippingUser(User user) {
		this.shippingUser = user;
	}

}
