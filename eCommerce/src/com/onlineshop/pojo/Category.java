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

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "CATEGORIES")
public class Category implements java.io.Serializable {

	private Long categoryId;
	private String categoryName;
	private String categoryDescription;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String isActive;
	private String deleted;
	private String isMenu;
	private Category category;
	private Set<Category> categories = new HashSet<Category>();
	private Set<Product> products = new HashSet<Product>();

	public Category() {

	}

	public Category(Long categoryId, String categoryName,
			String categoryDescription, Date createdDate, String createdBy,
			Date updatedDate, String updatedBy, String isActive, String deleted,String isMenu) {
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
		this.categoryName = categoryName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
		this.deleted = deleted;
		this.isMenu = isMenu;
	}
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "category_id")
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "category_name")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Column(name = "description")
	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
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
	@Column(name = "is_menu")
	public String getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(String isMenu) {
		this.isMenu = isMenu;
	}
		
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="parent_cat_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@OneToMany(mappedBy="category")
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	@OneToMany(mappedBy="category")
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
