package com.onlineshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineshop.exception.CategoryException;
import com.onlineshop.service.CategoryService;
import com.onlineshop.vo.CategoryVO;

@Controller
public class CategoryRestController {
	
	@Autowired
    private CategoryService categoryService;
	
	@RequestMapping(value = "/geAllMenuCategories",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<CategoryVO>>  geAllMenuCategories(){
		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		try {
			categoryList = categoryService.geAllMenuCategories();
		} catch (CategoryException e){
			e.printStackTrace();
			return null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return new ResponseEntity<List<CategoryVO>>(categoryList, HttpStatus.OK);
	}
}
