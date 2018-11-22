package com.javalow.datasources.annotation;

import java.lang.annotation.*;

/**
 * @Description: 多数据源注解
 * @Author: Satellite
 * @ClassName: DataSourceNames
 * http://www.javalow.com
 * @Date: 2018-11-18
 * @Time: 14:53
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
