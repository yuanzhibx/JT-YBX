package com.jt.controller;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-06
 */
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询user表的记录
     * 1.url地址: localhost:8090/findAll
     * 2.参数: 无
     * 3.返回值结果: 页面逻辑名称
     *
     * jsp中页面取值信息 : ${userList}  同步查询
     *
     * 2.作业2.利用ajax形式动态展现页面数据.
     *
     * 说明:
     * 		1. @Controller  + 返回值 String  表示跳转页面
     * 					必然经过视图解析器  拼接前缀和后缀
     *
     *      2. @RestController +任意返回值   直接返回JSON数据,不经过视图解析器.
     *         或者
     *         @Controller +@ ResponseBody
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> userList = userMapper.selectList(null);
        model.addAttribute("userList", userList);
        return "userList";
    }

    /**
     * 实现页面跳转
     * @return
     */
    @RequestMapping("/ajax")
    public String ajax(Model model) {
        return "ajax";
    }

    /**
     * 使用 Ajax 形式获取数据
     * @return
     */
    @RequestMapping("/findAjax")
    @ResponseBody
    public List<User> findAjax(){
        return userMapper.selectList(null);
    }

}
