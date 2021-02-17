package com.example.mp.controller;

import com.example.mp.entity.User;
import com.example.mp.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author Derek
 * @since 2021-02-17 14:55:09
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

}