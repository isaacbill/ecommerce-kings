package com.isaac.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.isaac.config.MyBatisConfig;
import com.isaac.model.Users;

@Service
public class UserService {
	
    public void registerUser(Users users) {
    	SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
    	try {
         session.insert("com.isaac.mapper.UserMapper.insertUser", users);
            session.commit();
        }finally {
        	session.close();
        }
    
    } 
    public Users loginUser(String email, String password) {
        SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
        try {
            Map<String, String> credentials = new HashMap<>();
            credentials.put("email", email);
            credentials.put("password", password);

            // Execute the SQL query directly
            return (Users) session.selectOne("com.isaac.mapper.UserMapper.loginUser", credentials);
        } finally {
            session.close();
        }
    }
}
