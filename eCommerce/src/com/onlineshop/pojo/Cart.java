package com.onlineshop.pojo;

import java.util.Date;

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
@Table(name = "CART")
public class Cart implements java.io.Serializable {

	private Long cartId;
	private Integer quantity;
	private String deleted;
	private Product product;
	private User user;

	public Cart() {

	}

	public Cart(Long cartId, Integer quantity, String deleted) {
		this.cartId = cartId;
		this.quantity = quantity;
		this.deleted = deleted;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "cart_id")
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	
	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Column(name = "deleted")
	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
}
