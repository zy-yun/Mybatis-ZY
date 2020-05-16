package com.zy.mybatis.v1.plugin;

import com.zy.mybatis.v1.annotation.Intercepts;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类，用于代理被拦截的对象，同时提供了创建代理类的方法
 */
public class Plugin implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    public Plugin(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }


    /**
     * 对被代理对象代理，返回代理类
     *
     * @param obj
     * @param interceptor
     * @return
     */
    public static Object wrap(Object obj, Interceptor interceptor) {
        Class aClass = obj.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), new Plugin(obj, interceptor));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //自定义的插件上有@Intercepts注解，指定了拦截的方法
        if (interceptor.getClass().isAnnotationPresent(Intercepts.class)) {

            //如果是被拦截的方法，则进入自定义拦截器的逻辑
            if (method.getName().equals(interceptor.getClass().getAnnotation(Intercepts.class).value())) {
                return interceptor.interceptor(new Invocation(target, method, args));
            }
        }
        //非被拦截对象，执行原有逻辑
        return method.invoke(target,method,args);


    }
}
