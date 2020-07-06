package com.jt.controller;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Yuanzhibx
 * @Date 2020-07-06
 */
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> userList = userMapper.selectList(null);
        model.addAttribute("userList", userList);
        return "userList";
    }

    /**
     * 实现页面
     * @return
     */
    public String ajax() {
        return "ajax";
    }

}
