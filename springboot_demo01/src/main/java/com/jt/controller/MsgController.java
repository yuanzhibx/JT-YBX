package com.jt.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过 yml 配置文件赋值
 * SpringBoot 注解
 * @RestController
 * @ConfigurationProperties(prefix = "msg") 通过 yml 为属性动态赋值, 绑定 msg
 *
 * Lombok 注解
 * @Accessors           开启链式加载结构
 * @Data                自动生成 get / set / ...
 * @Accessors(chain = true) 无参构造
 * @NoArgsConstructor   无参构造
 * @AllArgsConstructor  全参构造
 *
 * @author Yuanzhibx
 * @Date 2020-07-03
 */
@RestController
@ConfigurationProperties(prefix = "msg")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
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

    @RequestMapping("/getMsg")
    public String getMsg() {
        return "username = " + username + ", age = " + age;
    }

}
