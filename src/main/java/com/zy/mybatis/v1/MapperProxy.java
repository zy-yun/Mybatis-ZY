package com.zy.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理对象类，H对象
 */
public class MapperProxy implements InvocationHandler {

    private ZYSqlSession sqlSession;

    public MapperProxy(ZYSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 具体执行代理的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //类名.方法名=statementId
        String statementId = method.getDeclaringClass().getName() + "." + method.getName();

        //执行sqlsession中的查询方法，返回数据库中的对象
        return sqlSession.selectOne(statementId, args[0]);
    }
}
