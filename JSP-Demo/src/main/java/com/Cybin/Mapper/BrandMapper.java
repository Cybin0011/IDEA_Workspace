package com.Cybin.Mapper;

import com.Cybin.Pojo.Brand;
import org.apache.ibatis.annotations.*;

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
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status}); ")
    void add(Brand brand);
    @Select("select * from tb_brand where id=#{id};")
    @ResultMap("brandResultMap")
    Brand selectById(@Param("id") int id);
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id};" )
    void updateBrand(Brand brand);
}
