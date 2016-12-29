package com.onlineshop.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.exception.ProductException;
import com.onlineshop.pojo.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl() {
    }
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
    @Transactional
    public List<Product> list() {
		@SuppressWarnings("unchecked")
        List<Product> listProducts = (List<Product>) sessionFactory.getCurrentSession()
                .createCriteria(Product.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listProducts;
    }
	
	@Override
    @Transactional
    public void saveOrUpdate(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }
	
	@Override
    @Transactional
    public void delete(int id) {
		Product productToDelete = new Product();
		productToDelete.setProductId(new Long(id));
        sessionFactory.getCurrentSession().delete(productToDelete);
    }
	
	@Override
    @Transactional
    public Product get(int id) {
        String hql = "from Product where  isActive='Y' and deleted='N' and productId=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Product> listProduct = (List<Product>) query.list();
         
        if (listProduct != null && !listProduct.isEmpty()) {
            return listProduct.get(0);
        }
         
        return null;
    }
	
	@Transactional
	public List<Product> getLatestProducts() throws ProductException {
		List<Product> returnList = null;
		Calendar c =  Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -7);
		Date d = c.getTime();
		try {
			String hql = "from Product where createdDate > :date and isActive='Y' and deleted='N' order by createdDate desc";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setCalendarDate("date", c);
			returnList = query.list();
		} catch(Exception e){
			e.printStackTrace();
			throw new ProductException("Error While accessing Latest Products");
		}
		return returnList;
	}
	
	@Transactional
	public List<Product> getFeatureProducts() throws ProductException {
		List<Product> returnList = null;
		try {
			String hql = "from Product where featured='Y' and isActive='Y' and deleted='N'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			returnList = query.list();
		} catch(Exception e){
			e.printStackTrace();
			throw new ProductException("Error While accessing Featured Products");
		}
		return returnList;
	}
	
	@Transactional
	public List<Product> getProductsByCategory(String categoryId)  throws ProductException {
		List<Product> returnList = null;
		try {
			String hql = "from Product where category.categoryId='"+categoryId+"' and isActive='Y' and deleted='N'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			returnList = query.list();
		} catch(Exception e){
			e.printStackTrace();
			throw new ProductException("Error While accessing Featured Products");
		}
		return returnList;
	}
	
	@Transactional
	public Double getProductPriceById(String productId)  throws ProductException {
		Double productPrice = null;
		try {
			String hql = "select unitPrice from Product where productId='"+productId+"' and isActive='Y' and deleted='N'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			productPrice = (Double)query.list().get(0);
		} catch(Exception e){
			throw new ProductException("Error While accessing Product Price");
		}
		return productPrice;
	}
}
