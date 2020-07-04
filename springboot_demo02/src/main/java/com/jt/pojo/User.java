package com.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Yuanzhibx
 * @Date 2020-07-04
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;

}
