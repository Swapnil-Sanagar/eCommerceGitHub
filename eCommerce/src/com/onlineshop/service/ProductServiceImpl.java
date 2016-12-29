package com.onlineshop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.ProductDAO;
import com.onlineshop.exception.ProductException;
import com.onlineshop.pojo.Product;
import com.onlineshop.vo.ProductVO;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService {
	
	@Autowired
    private ProductDAO productDao;
	
	public List<ProductVO>  getLatestProducts() throws ProductException {
		List<ProductVO> productList = new ArrayList<ProductVO>();
		try {
			List<Product> productDOList = productDao.getLatestProducts();
			for(Product product :  productDOList){
				ProductVO productVO = new ProductVO(); 
				BeanUtils.copyProperties(productVO,product);
				productList.add(productVO);
			}
			
		} catch (Exception e){
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}
		return productList;
	}
	
	public List<ProductVO>  getFeaturedProducts() throws ProductException {
		List<ProductVO> productList = new ArrayList<ProductVO>();
		try {
			List<Product> productDOList = productDao.getFeatureProducts();
			for(Product product :  productDOList){
				ProductVO productVO = new ProductVO();
				BeanUtils.copyProperties(productVO,product);
				productList.add(productVO);
			}
			
		} catch (Exception e){
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}
		return productList;
	}
	
	public List<ProductVO>  getProductsByCategory(String categoryId) throws ProductException {
		List<ProductVO> productList = new ArrayList<ProductVO>();
		try {
			List<Product> productDOList = productDao.getProductsByCategory(categoryId);
			for(Product product :  productDOList){
				ProductVO productVO = new ProductVO();
				BeanUtils.copyProperties(productVO,product);
				productList.add(productVO);
			}
			
		} catch (Exception e){
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}
		return productList;
	}
	
	public Double getProductPriceById(String productId) throws ProductException {
		Double price = null;
		try {
			price = productDao.getProductPriceById(productId);
		} catch (Exception e){
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}
		return price;
	}
}
