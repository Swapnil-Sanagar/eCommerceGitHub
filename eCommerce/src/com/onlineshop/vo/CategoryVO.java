package com.onlineshop.vo;

import java.util.HashSet;
import java.util.Set;

public class CategoryVO {

	public String categoryId;
	private String categoryName;
	private String categoryDescription;
	private CategoryVO categoryVO;

	private Set<CategoryVO> categories = new HashSet<CategoryVO>();

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public CategoryVO getCategoryVO() {
		return categoryVO;
	}

	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	public Set<CategoryVO> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryVO> categories) {
		this.categories = categories;
	}

}
