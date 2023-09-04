package com.isaac.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.isaac.config.MyBatisConfig;
import com.isaac.model.Category;

@Service
public class CategoryService {
	
		public Category getCategoryByName(String categoryname) {
		    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
		    try {
		    	Category category = (Category) session.selectOne("com.isaac.mapper.CategoryMapper.getCategoryByName", categoryname);
		        return category;
		    } finally {
		        session.close();
		    }
		}
		
		public List<Category> getAllCategories() {
			  SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
			  try {
			    @SuppressWarnings("unchecked")
				List<Category> category = session.selectList("com.isaac.mapper.CategoryMapper.getAllCategories");
			    return category;
			  } finally {
			    session.close();
			  }
			}


}
