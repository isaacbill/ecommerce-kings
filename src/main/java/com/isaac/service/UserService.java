package com.isaac.service;

import org.apache.ibatis.session.SqlSession;
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

//    public Users findByUsername(String username) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            return session.selectOne("com.isaac.mapper.UserMapper.findByUsername", username);
//        }
//    }
//
//    public Users findByEmail(String email) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            return session.selectOne("com.isaac.mapper.UserMapper.findByEmail", email);
//        }
//    }

}
