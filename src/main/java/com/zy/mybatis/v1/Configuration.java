package com.zy.mybatis.v1;

import java.lang.reflect.Proxy;

/**
 * 全局配置信息类
 */
public class Configuration {

    private DataSourceProperties dataSourceProperties;

    public Configuration(DataSourceProperties dataSourceProperties){
        this.dataSourceProperties = dataSourceProperties;
    }

    /**
     * 根据statementId获取指定的执行sql
     * @param statementId
     * @return
     */
    public String getSql(String statementId) {

        return dataSourceProperties.sqlSourceBinding.getString(statementId);
    }

    /**
     * 获取代理clazz mapper接口的代理对象
     * @param clazz
     * @param sqlSession
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz,ZYSqlSession sqlSession) {

        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }
}
