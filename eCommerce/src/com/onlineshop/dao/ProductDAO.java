package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.exception.ProductException;
import com.onlineshop.pojo.Product;

public interface ProductDAO {
	
	public List<Product> list();

	public Product get(int id);

	public void saveOrUpdate(Product F);

	public void delete(int id);
	
	public List<Product> getLatestProducts() throws ProductException;
	
	public List<Product> getFeatureProducts() throws ProductException;
	
	public List<Product> getProductsByCategory(String categoryId)  throws ProductException;
	
	public Double getProductPriceById(String productId)  throws ProductException;
}
