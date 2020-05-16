package com.zy.mybatis.v1.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 包装类，对被代理对象进行包装
 *
 * @Author zhangyun
 */
public class Invocation {

    /**
     * 代理的目标对象
     */
    private Object target;
    /**
     * 代理的方法
     */
    private Method method;
    /**
     * 参数数组
     */
    private Object[] args;


    public Invocation(Object target, Method method, Object[] args){
        this.target = target;
        this.method = method;
        this.args = args;

    }


    /**
     * 包装类的执行代理对象方法
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object proceed() throws InvocationTargetException, IllegalAccessException {

        return method.invoke(target,args);
    }



    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
