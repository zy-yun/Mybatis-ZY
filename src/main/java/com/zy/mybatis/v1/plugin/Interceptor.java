package com.zy.mybatis.v1.plugin;

import java.lang.reflect.InvocationTargetException;

/**
 * 自定义插件必须实现的拦截器接口
 *
 * @Author zhangyun
 */
public interface Interceptor {


    /**
     * 插件的核心逻辑实现
     *
     * @param invocation
     * @return
     */
    Object interceptor(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    /**
     *对被拦截对象进行代理
     * @param target
     * @return
     */
    Object plugin(Object target);
}
