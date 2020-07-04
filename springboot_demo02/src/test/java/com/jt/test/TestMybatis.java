package com.jt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
     * 查
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

    /**
     * 增
     * MyBatisPlus 方式新增数据
     */
    @Test
    void insertMP() {
        User user = new User();
        user.setName("Yuanzhibx").setAge(13).setSex("男");
        userMapper.insert(user);
        System.out.println("新增成功");
    }

    /**
     * 查
     * 查询用户 id = 53 的用户数据
     */
    @Test
    void selectMP01() {
        User user = userMapper.selectById(53);
        System.out.println(user);
    }

    /**
     * 查
     * 查询 name = "孙尚香" sex = "女" 的用户数据
     * 1. 利用对象封装参数, 实现数据查询
     *      利用对象只能实现 "=" 操作
     * 2. 利用条件构造器构造 where 条件
     *      利用条件构造器可以实现其他逻辑操作
     *
     * 逻辑运算符
     *      =   eq
     *      >   gt
     *      <   lt
     *      >=  ge
     *      <=  le
     */
    @Test
    void selectMP02() {
        //1. 利用对象封装参数, 实现数据查询
        User user = new User();
        user.setName("孙尚香").setSex("女");
        //根据对象中不为 null 的元素拼接 where 条件, 默认条件下使用 and 连接符
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user1 : users) {
            System.out.println(user1);
        }

        System.out.println("----------------");

        //2. 利用条件构造器构造 where 条件
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("name", "孙尚香").eq("sex", "女");
        List<User> userList = userMapper.selectList(queryWrapper2);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

    /**
     * 查
     * 查询用户 age < 18 或 age > 100 的用户数据
     */
    @Test
    void selectMP03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age", 18).or().gt("age", 100);
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查
     * 查询用户 id = 1, 3, 5 的用户数据
     * 1. API 进行封装
     * 2. 条件构造器进行封装
     */
    @Test
    void selectMP04() {
        //1. API 进行封装
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        List<User> users = userMapper.selectBatchIds(list);
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("-----------");

        //2. 条件构造器进行封装
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",1, 3, 5);
        List<User> users1 = userMapper.selectList(queryWrapper);
        for (User user : users1) {
            System.out.println(user);
        }
    }

    /**
     * 查
     * 其他常用查询条件
     */
    @Test
    void selectMP05() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age", 10, 30);
        //名字包含 yuan   [%yuan%]
//        queryWrapper.like("name", "yuan");
        //名字以 精 结尾   [ %精 ]
        queryWrapper.likeLeft("name", "精");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
