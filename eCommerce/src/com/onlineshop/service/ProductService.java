package com.onlineshop.service;

import java.util.List;

import com.onlineshop.exception.ProductException;
import com.onlineshop.vo.ProductVO;

public interface ProductService {
	public List<ProductVO>  getLatestProducts() throws ProductException;
	public List<ProductVO>  getFeaturedProducts() throws ProductException;
	public List<ProductVO>  getProductsByCategory(String categoryId) throws ProductException;
	public Double getProductPriceById(String productId) throws ProductException;
}
