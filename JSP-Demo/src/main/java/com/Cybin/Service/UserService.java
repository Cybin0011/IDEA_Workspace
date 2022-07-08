package com.Cybin.Service;

import com.Cybin.Mapper.BrandMapper;
import com.Cybin.Mapper.UserMapper;
import com.Cybin.Pojo.Brand;
import com.Cybin.Pojo.User;
import com.Cybin.Utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author Chen Yuanbin
 * @description TODO
 * @create 2022-07-05 22:38
 */
public class UserService {

   SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
/*
 * @param username:
 * @param password:
 * @return
 * @author
 * @description 判断登录功能
 * @date
 */
   public User select(String username,String password){
      SqlSession sqlSession = sqlSessionFactory.openSession(true);
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      User user = mapper.select(username, password);
      sqlSession.close();
      return user;
   }
   public boolean register(User new_user){
      SqlSession sqlSession = sqlSessionFactory.openSession(true);
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      User user = mapper.selectByUsername(new_user.getUsername());
      if (user == null) {
//             用户名合法，可以注册
         mapper.add(new_user);
      }else {
//            用户名已存在，不能注册
         return false;
      }
      sqlSession.close();
     return true;
   }

}
