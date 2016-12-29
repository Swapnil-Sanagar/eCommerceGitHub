package com.onlineshop.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment implements java.io.Serializable {
	
	private Long paymentId;
	
	private String paymentType;
	
	private String allowed;
	
	private Set<Order> orders  = new HashSet<Order>();
	
	public Payment() {

	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "payment_id")
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	
	@Column(name = "payment_type")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	@Column(name = "allowed")
	public String getAllowed() {
		return allowed;
	}

	public void setAllowed(String allowed) {
		this.allowed = allowed;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="payment")
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
