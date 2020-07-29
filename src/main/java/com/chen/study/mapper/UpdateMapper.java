package com.chen.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UpdateMapper {

    @Update("UPDATE testprop SET VALUE=#{newValue} WHERE `key`='name'")
    public int updateName(@Param("newValue") String newValue);

}
