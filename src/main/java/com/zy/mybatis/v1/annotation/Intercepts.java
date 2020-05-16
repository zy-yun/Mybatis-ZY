package com.zy.mybatis.v1.annotation;

import java.lang.annotation.*;

/**
 * 用于注解拦截器，拦截指定的拦截方法
 *
 * @Author zhangyun
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Intercepts {
    String value();
}
