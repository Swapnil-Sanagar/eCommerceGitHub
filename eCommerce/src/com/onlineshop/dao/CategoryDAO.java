package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.exception.CategoryException;
import com.onlineshop.vo.CategoryVO;

public interface CategoryDAO {
	public List<CategoryVO> geAllMenuCategories() throws CategoryException;
}
