package com.onlineshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.exception.CategoryException;
import com.onlineshop.vo.CategoryVO;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryDAO categoryDao;
	
	public List<CategoryVO>  geAllMenuCategories()  throws CategoryException {
		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		try {
			categoryList = categoryDao.geAllMenuCategories();
		} catch (Exception e){
			e.printStackTrace();
			throw new CategoryException(e.getMessage());
		}
		return categoryList;
	}
}
