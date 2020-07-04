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

    @Test
    void findAll() {
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }

}
