package com.lev1.springboot.mapper;

import com.lev1.springboot.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select * from user where id = #{id}")
    public User getUserById(Integer id);
}
