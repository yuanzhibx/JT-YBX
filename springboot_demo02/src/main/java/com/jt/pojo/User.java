package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * MyBatis Plus
 * @TableName("user") 与表进行关联, 如果名称一致, 则可以省略不写
 * @TableId(type = IdType.AUTO) 主键自增标识
 * @TableField(value = "name") 标识表内属性字段, 如果属性名称与字段名称一致(包含驼峰规则)可以不写
 *
 * @author Yuanzhibx
 * @Date 2020-07-04
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String sex;

}
