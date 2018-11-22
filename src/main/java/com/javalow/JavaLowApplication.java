package com.javalow;

import com.javalow.datasources.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @anthor Satellite
 * JavaLowApplication
 * Boot启动类
 * http://www.javalow.com
 * @date 2018-11-18-13:50
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class JavaLowApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JavaLowApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JavaLowApplication.class);
    }

}
