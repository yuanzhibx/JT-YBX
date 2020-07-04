package com.jt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuanzhibx
 * @Date 2020-07-03
 */
@RestController
public class MasController {

    @RequestMapping("/getMsg")
    public String getMsg() {
        return "springBoot测试方法";
    }

}
