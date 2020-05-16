package com.zy.mybatis.v1.Executor;

/**
 * 执行器接口，定义基本的操作类型
 *
 * @Author zhangyun
 */
public interface Executor {

    <T> T query(String statement, Object args);
}
