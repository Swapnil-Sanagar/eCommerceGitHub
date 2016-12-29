package com.onlineshop.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.exception.CategoryException;
import com.onlineshop.pojo.Category;
import com.onlineshop.vo.CategoryVO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl() {
    }
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public void setRecursiveCategories(CategoryVO targetSubCategoryVO) throws Exception {
		if(targetSubCategoryVO.getCategories().size() > 0){
			Set<CategoryVO> subLevel2CategoryVOLists = new HashSet<CategoryVO>();
			for(Object subLevel2CategoryVO :  targetSubCategoryVO.getCategories()){
				Category subLevel2Category = (Category)subLevel2CategoryVO;
				CategoryVO targetSubLevel2CategoryVO = new CategoryVO();
				BeanUtils.copyProperties(targetSubLevel2CategoryVO,subLevel2Category);
				subLevel2CategoryVOLists.add(targetSubLevel2CategoryVO);
				if(targetSubLevel2CategoryVO.getCategories().size() > 0){
					setRecursiveCategories(targetSubLevel2CategoryVO);
				}
			}
			targetSubCategoryVO.setCategories(subLevel2CategoryVOLists);
		}
	}
	
	@Transactional
	public List<CategoryVO> geAllMenuCategories() throws CategoryException {
		List<CategoryVO> returnList = new ArrayList<CategoryVO>();
		try {
			String hql = "from Category where isMenu = 'Y' and isActive='Y' and deleted='N'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Category> categoryList = query.list();
			
			List<CategoryVO> categoryVOList = new ArrayList<CategoryVO>();
			for(Category category :  categoryList){
				CategoryVO categoryVO = new CategoryVO();
				BeanUtils.copyProperties(categoryVO,category);
				categoryVOList.add(categoryVO);
			}
			for(CategoryVO categoryVO: categoryVOList){
				if(categoryVO.getCategories().size() > 0){	
					Set<CategoryVO> subCategoryVOLists = new HashSet<CategoryVO>();
					for(Object subCategoryVO :  categoryVO.getCategories()){
						Category subCategory = (Category)subCategoryVO;
						CategoryVO targetSubCategoryVO = new CategoryVO();
						BeanUtils.copyProperties(targetSubCategoryVO,subCategory);
						subCategoryVOLists.add(targetSubCategoryVO);
						setRecursiveCategories(targetSubCategoryVO);
					}
					categoryVO.setCategories(subCategoryVOLists);
				}
				returnList.add(categoryVO);
			}
		} catch(Exception e){
			e.printStackTrace();
			throw new CategoryException("Error While fetching Menu Categories");
		}
		return returnList;
	}
}
