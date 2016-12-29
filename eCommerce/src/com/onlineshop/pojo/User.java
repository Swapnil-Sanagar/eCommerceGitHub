package com.onlineshop.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Users")
public class User implements java.io.Serializable  {
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String fax;
	private String password;
	private String passwordConfirm;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String enabled;
/*	private String address1;
	private String address2;*/
	private List<UserRole> userRoles = new ArrayList<UserRole>();
	private List<Address> address = new ArrayList<Address>();
	private List<ShippingAddress> shippingAddresses = new ArrayList<ShippingAddress>();
	private Set<Order> orders  = new HashSet<Order>();
	
	public User() {

	}

	public User(Long userId, String userName,  String firstName,String lastName,
			String phone, String fax, String password, String city,
			String state, String country, String zip, String address1,
			String address2) {
		super();
		this.userId = userId;
		this.email = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.fax = fax;
		this.password = password;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		/*this.address1 = address1;
		this.address2 = address2;*/
	}
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name = "user_name")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "fax")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	/*@Column(name = "address1")
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
	}*/
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="roleUser")
	public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
    
    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="shippingUser")
	public List<ShippingAddress> getShippingAddresses() {
		return shippingAddresses;
	}

	public void setShippingAddresses(List<ShippingAddress> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}
    
	@OneToMany(cascade=CascadeType.ALL,mappedBy="payment")
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
