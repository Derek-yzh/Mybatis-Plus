package com.example.mp.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: Derek
 * @DateTime: 2021/2/17 15:38
 * @Description: MybatisPlus乐观锁配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.example.mp.mapper","com.example.mp.dao"})
public class MybatisPlusConfig {

    /**
     * 乐观锁插件
     * @return OptimisticLockerInterceptor
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
