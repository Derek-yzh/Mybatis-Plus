package com.example.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mp.entity.User;
import com.example.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Derek
 * @DateTime: 2021/2/17 16:47
 * @Description: TODO
 */
@SpringBootTest
@SuppressWarnings("all")
public class QueryWrapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 名称模糊查询
     */
    @Test
    public void testSelectDemo4() {
        //1 构建条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","name","age");//查询指定的列
        wrapper.like("name","o");
        //wrapper.likeRight("name","o");//百分号在右侧
        wrapper.orderByDesc("age");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /**
     * 查询年龄在20-40
     */
    @Test
    public void testSelectDemo3() {
        //1 构建条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 年龄在20-40
        wrapper.between("age",20,40);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /**
     * 查询用户名称是jack，并且年龄是33的记录
     */
    @Test
    public void testSelectDemo2() {
        //1 构建条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 用户名称是jack
        wrapper.eq("name","BBB");
        wrapper.eq("age",18);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /**
     * 查询年龄大于80的人
     */
    @Test
    public void testSelectDemo1(){
        //1 构建条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // age>80
        wrapper.gt("age",80);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

}
