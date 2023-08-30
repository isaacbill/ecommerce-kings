package com.isaac.config;

import java.io.Reader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig implements ServletContextListener {
	static SqlSessionFactory sqlSessionFactory;
	 public void contextInitialized(ServletContextEvent event) {
		 
		
	     ServletContext serContext = event.getServletContext();
	     @SuppressWarnings("unused")
		String resource = "mybatis-config.xml";

	     try {
	    	 Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
	    	 sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); 
	         serContext.setAttribute("sqlSessionFactory", sqlSessionFactory);
	     } catch(Exception e){
	    	 System.out.println("FATAL ERROR: myBatis could not be initialized");
	    	 e.printStackTrace();
	    	 System.exit(9);
	    }
		 
	 }

	 public void contextDestroyed(ServletContextEvent event){

	 }
	 public static SqlSessionFactory getSqlSessionFactory(){
		
			return sqlSessionFactory;
	
		 }

}
