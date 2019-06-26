package com.lev1.springboot.mapper;

import com.lev1.springboot.entities.EmailInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {

    @Insert("insert into email_info (name, addr) values (#{name},#{addr,jdbcType=VARCHAR})")
    public int saveEmailInfo(EmailInfo emailInfo);
}
