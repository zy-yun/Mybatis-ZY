package com.zy.mybatis.v1.interceptor;

import com.zy.mybatis.v1.annotation.Intercepts;
import com.zy.mybatis.v1.plugin.Interceptor;
import com.zy.mybatis.v1.plugin.Invocation;
import com.zy.mybatis.v1.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;

/**
 * 自定义插件
 * 实现功能：实现查询sql及参数的打印
 *
 * @Author zhangyun
 * @Date 2020/06/15 20:02 PM
 */
@Intercepts("query")
public class MySqlPlugin implements Interceptor {


    public Object interceptor(Invocation invocation)  throws InvocationTargetException, IllegalAccessException {
        Object statement = invocation.getArgs()[0];
        Object arg = invocation.getArgs()[1];
        System.out.println("查询的sql为：" + statement.toString());
        System.out.println("查询的参数为：" + arg.toString());
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
