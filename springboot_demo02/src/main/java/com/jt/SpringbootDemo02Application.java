package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuanzhibx
 */
@SpringBootApplication
@MapperScan("com.jt.mapper")
public class SpringbootDemo02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo02Application.class, args);
    }

}
