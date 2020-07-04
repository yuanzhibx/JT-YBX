package com.jt.mapper;

import com.jt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-04
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有的用户表记录
     *
     * @return
     */
    @Select("SELECT id, name, age, sex FROM user")
    List<User> findAll();

}
