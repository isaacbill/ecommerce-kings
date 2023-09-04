package com.isaac.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.isaac.config.MyBatisConfig;
import com.isaac.model.Products;

@Service
public class ProductsService {
	
		public List<Products> getAllProducts() {
		  SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
		  try {
		    @SuppressWarnings("unchecked")
			List<Products> products = session.selectList("com.isaac.mapper.ProductMapper.getAllProducts");
		    return products;
		  } finally {
		    session.close();
		  }
		}
}
