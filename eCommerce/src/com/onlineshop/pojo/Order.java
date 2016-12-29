package com.onlineshop.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements java.io.Serializable {

	private Long orderId;

	private Long orderNumber;

	private Date orderDate;

	private Date shipmentDate;

	private String transactionStatus;

	private String errorMessage;

	private String deleted;

	private String paid;

	private Date paymentDate;

	private User user;

	private Payment payment;
	
	private Set<OrderDetails> orderDetailsSet = new HashSet<OrderDetails>();
	
	public Order() {

	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "order_id")
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	@Column(name = "order_number")
	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	@Column(name = "order_date")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Column(name = "shipment_date")
	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	@Column(name = "transaction_status")
	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	@Column(name = "error_message")
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Column(name = "deleted")
	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	@Column(name = "paid")
	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}
	@Column(name = "payment_date")
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="fk_payment_id")
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order")
	public Set<OrderDetails> getOrderDetailsSet() {
		return orderDetailsSet;
	}

	public void setOrderDetailsSet(Set<OrderDetails> orderDetailsSet) {
		this.orderDetailsSet = orderDetailsSet;
	}
}
