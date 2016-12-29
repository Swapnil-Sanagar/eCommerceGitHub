package com.onlineshop.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product implements java.io.Serializable {
	private Long productId;
	private String sku;
	private String productName;
	private String productDescription;
	private Long categoryPerUnit;
	private Double unitPrice;
	private Double msrp;
	private String availableSizes;
	private String availableColors;
	private Integer size;
	private String color;
	private Double discount;
	private String productAvailable;
	private String discountAvailable;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String isActive;
	private String deleted;
	private String featured;
	private String imageName;
	private Category category;
	private Set<OrderDetails> orderDetailsSet = new HashSet<OrderDetails>();

	public Product() {

	}

	public Product(String sku, String productName, String productDescription,
			Long categoryPerUnit, Double unitPrice, Double msrp,
			String availableSizes, String availableColors, Integer size,
			String color, Double discount, String productAvailable,
			String discountAvailable, Date createdDate, String createdBy,
			Date updatedDate, String updatedBy, String isActive, String deleted,String featured) {
		this.sku = sku;
		this.productName = productName;
		this.productDescription = productDescription;
		this.categoryPerUnit = categoryPerUnit;
		this.unitPrice = unitPrice;
		this.msrp = msrp;
		this.availableSizes = availableSizes;
		this.availableColors = availableColors;
		this.size = size;
		this.color = color;
		this.discount = discount;
		this.productAvailable = productAvailable;
		this.discountAvailable = discountAvailable;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
		this.deleted = deleted;
		this.featured = featured;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "product_id")
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	@Column(name = "sku")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Column(name = "product_description")
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	@Column(name = "quantity_per_unit")
	public Long getCategoryPerUnit() {
		return categoryPerUnit;
	}

	public void setCategoryPerUnit(Long categoryPerUnit) {
		this.categoryPerUnit = categoryPerUnit;
	}
	@Column(name = "unit_price")
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Column(name = "msrp")
	public Double getMsrp() {
		return msrp;
	}

	public void setMsrp(Double msrp) {
		this.msrp = msrp;
	}
	@Column(name = "available_sizes")
	public String getAvailableSizes() {
		return availableSizes;
	}

	public void setAvailableSizes(String availableSizes) {
		this.availableSizes = availableSizes;
	}
	@Column(name = "available_colors")
	public String getAvailableColors() {
		return availableColors;
	}

	public void setAvailableColors(String availableColors) {
		this.availableColors = availableColors;
	}
	@Column(name = "size")
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	@Column(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Column(name = "discount")
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	@Column(name = "product_available")
	public String getProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(String productAvailable) {
		this.productAvailable = productAvailable;
	}
	@Column(name = "discount_available")
	public String getDiscountAvailable() {
		return discountAvailable;
	}

	public void setDiscountAvailable(String discountAvailable) {
		this.discountAvailable = discountAvailable;
	}
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Column(name = "updated_by")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Column(name = "active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Column(name = "is_deleted")
	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	@Column(name = "featured")
	public String getFeatured() {
		return featured;
	}

	public void setFeatured(String featured) {
		this.featured = featured;
	}
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="product")
	public Set<OrderDetails> getOrderDetailsSet() {
		return orderDetailsSet;
	}

	public void setOrderDetailsSet(Set<OrderDetails> orderDetailsSet) {
		this.orderDetailsSet = orderDetailsSet;
	}
	@Column(name = "imageName")
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
}
