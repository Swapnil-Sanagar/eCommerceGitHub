package com.onlineshop.pojo;

import java.util.Date;

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
@Table(name = "order_details")
public class OrderDetails implements java.io.Serializable {

	private Long orderDetailsId;

	private Double price;

	private Long quantity;

	private Long discount;

	private String size;

	private String color;

	private Date billingDate;

	private Date shipmentDate;

	private Product product;

	private Order order;
	
	public OrderDetails() {

	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "order_details_id")
	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	@Column(name = "price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@Column(name = "quantity")
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name = "discount")
	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	@Column(name = "size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Column(name = "billing_date")
	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	@Column(name = "shipment_date")
	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_ProductId")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_OrderId")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
