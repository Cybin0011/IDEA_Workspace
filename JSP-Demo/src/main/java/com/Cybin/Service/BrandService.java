package com.Cybin.Service;

import com.Cybin.Mapper.BrandMapper;
import com.Cybin.Pojo.Brand;
import com.Cybin.Utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author Chen Yuanbin
 * @description TODO
 * @create 2022-07-05 22:38
 */
public class BrandService {

   SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
   public List<Brand> selectAll(){
      SqlSession sqlSession = sqlSessionFactory.openSession();
      BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
      List<Brand> brands = mapper.selectAll();
      sqlSession.close();
      return brands;
   }
   public void add(Brand brand){
      SqlSession sqlSession = sqlSessionFactory.openSession(true);
      BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
      mapper.add(brand);
      sqlSession.close();
   }
}
