package com.xyz.actor.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Xyz
 * @Date 2021/6/26
 */

@Configuration
@MapperScan("com.xyz.actor.mapper")
public class ActorConfig {
//   逻辑删除
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

//    分页查询
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
