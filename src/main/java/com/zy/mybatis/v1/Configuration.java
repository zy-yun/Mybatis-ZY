package com.zy.mybatis.v1;

import com.zy.mybatis.v1.Executor.Executor;
import com.zy.mybatis.v1.Executor.SimpleExecutor;
import com.zy.mybatis.v1.plugin.Interceptor;
import com.zy.mybatis.v1.plugin.InterceptorChain;

import java.lang.reflect.Proxy;

/**
 * 全局配置信息类
 */
public class Configuration {

    private DataSourceProperties dataSourceProperties;

    private InterceptorChain interceptorChain = new InterceptorChain();

    public Configuration(DataSourceProperties dataSourceProperties){
        this.dataSourceProperties = dataSourceProperties;
        //初始化插件配置
        String[] split = dataSourceProperties.getPluginPath().split(",");
        Interceptor interceptor = null;
        for (String plugin: split
             ) {
            try {
                interceptor = (Interceptor) Class.forName(plugin).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            interceptorChain.addInterceptor(interceptor);
        }

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

    public Executor newExecutor(){
        Executor executor = new SimpleExecutor(dataSourceProperties);
        if (interceptorChain.hasPlugin()){
            return (Executor)interceptorChain.pluginAll(executor);
        }
        return executor;
    }
}
