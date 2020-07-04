package com.jt.test;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-04
 */
@SpringBootTest
public class TestMybatis {

    @Autowired
    private UserMapper userMapper;

    /**
     * MyBatis 方式查询所有数据
     */
    @Test
    void findAll() {
        List<User> list = userMapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * MyBatisPlus 方式查询所有数据
     * 单表操作可不写 SQL 语句
     */
    @Test
    void findAllMP() {
        List<User> list = userMapper.selectList(null);
        for (User user : list) {
            System.out.println(user);
        }
    }

}
