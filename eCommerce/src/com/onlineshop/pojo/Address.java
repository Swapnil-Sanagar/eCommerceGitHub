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
@Table(name = "address")
public class Address implements java.io.Serializable {
	private Long addressId;
	private String company;
	private String companyId;
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String country;
	private String region;
	private User user;
	
	public Address(){
		
	}
	
	public Address(Long addressId, String company, String companyId,
			String address1, String address2, String city, String zip,
			String country, String region) {
		super();
		this.addressId = addressId;
		this.company = company;
		this.companyId = companyId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.region = region;
	}
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "address_id")
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	@Column(name = "company_id")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="fk_user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
