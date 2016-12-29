package com.onlineshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineshop.exception.ProductException;
import com.onlineshop.service.ProductService;
import com.onlineshop.vo.AddressForm;
import com.onlineshop.vo.ProductVO;
import com.onlineshop.vo.UserForm;

@Controller
public class ProductRestController {
	
	@Autowired
    private ProductService productService;
	
	@RequestMapping(value = "/getLatestProducts",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<ProductVO>>  getLatestProducts(){
		List<ProductVO> productList = new ArrayList<ProductVO>();
		try {
			productList = productService.getLatestProducts();
		} catch (ProductException e){
			e.printStackTrace();
			return null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return new ResponseEntity<List<ProductVO>>(productList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFeaturedProducts",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<ProductVO>>  getFeaturedProducts(){
		List<ProductVO> productList = new ArrayList<ProductVO>();
		try {
			productList = productService.getFeaturedProducts();
		} catch (ProductException e){
			e.printStackTrace();
			return null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return new ResponseEntity<List<ProductVO>>(productList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getProductsByCategory/{id}",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<ProductVO>>  getProductsByCategory(@PathVariable("id") String categoryId){
		List<ProductVO> productList = new ArrayList<ProductVO>();
		try {
			productList = productService.getProductsByCategory(categoryId);
		} catch (ProductException e){
			e.printStackTrace();
			return null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return new ResponseEntity<List<ProductVO>>(productList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String cartPage(ModelMap model) {
		return "checkout";
	}
}
