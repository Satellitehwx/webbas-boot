package com.javalow.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: mybatis-plus配置
 * @Author: Satellite
 * @ClassName: DataSourceNames
 * http://www.javalow.com
 * @Date: 2018-11-18
 * @Time: 14:53
 */
@Configuration
@MapperScan("com.javalow.modules.*.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
