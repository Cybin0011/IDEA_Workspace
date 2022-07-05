package com.Cybin.Mapper;

import com.Cybin.Pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Chen Yuanbin
 * @description TODO
 * @create 2022-07-05 21:50
 */
public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();
    @Insert("insert into tb_brand values(null,#{brandName},#{CompanyName},#{ordered},#{description},#{status}); ")
    void add(Brand brand);
}
