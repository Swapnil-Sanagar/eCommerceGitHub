package com.onlineshop.service;

import java.util.List;

import com.onlineshop.exception.CategoryException;
import com.onlineshop.vo.CategoryVO;

public interface CategoryService {
	public List<CategoryVO>  geAllMenuCategories() throws CategoryException;
}
