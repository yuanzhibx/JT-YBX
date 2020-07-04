package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 常用注解
 * @PropertySource()
 *      value = 配置文件的加载路径,
 *      encoding = 字符编码集(windows 系统下默认条件下使用 ISO-8859-1, 有可能有中文乱码问题)
 *
 * @author Yuanzhibx
 * @Date 2020-07-04
 */
@RestController
@PropertySource(value = "classpath:/properties/msg.properties", encoding = "UTF-8")
public class MsgController2 {

    @Value("${msg.username}")
    private String username;
    @Value("${msg.age}")
    private Integer age;

    @RequestMapping("/getMsg2")
    public String getMsg2() {
        return "username = " + username + ", age = " + age;
    }

}
