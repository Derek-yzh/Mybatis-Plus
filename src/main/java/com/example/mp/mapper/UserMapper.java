package com.example.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mp.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Derek
 * @DateTime: 2021/2/17 12:23
 * @Description: UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
