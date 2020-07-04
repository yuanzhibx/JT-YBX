package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过 yml 配置文件赋值
 *
 * @author Yuanzhibx
 * @Date 2020-07-03
 */
@RestController
@ConfigurationProperties(prefix = "msg")
public class MsgController {

    /**
     * 通过配置文件为属性动态赋值
     *
     * @Value 表示从 Spring 容器中动态获取数据, 通过 spel 表达式动态取值
     */
//    @Value("${msg.username}")
//    private String username;
//    @Value("${msg.age}")
//    private Integer age;

    /**
     * 批量为属性赋值
     */
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @RequestMapping("/getMsg")
    public String getMsg() {
        return "username = " + username + ", age = " + age;
    }

}
