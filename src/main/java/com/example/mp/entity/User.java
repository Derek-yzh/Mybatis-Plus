package com.example.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author Derek
 * @since 2021-02-17 14:55:05
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -19694618421708471L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 邮箱
    */
    private String email;

    @TableField(fill = FieldFill.INSERT)//创建时间在添加数据的时候
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)//创建时间在修改数据的时候
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

}