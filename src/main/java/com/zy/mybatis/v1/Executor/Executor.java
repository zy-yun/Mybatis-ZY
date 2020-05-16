package com.zy.mybatis.v1.Executor;

public interface Executor {

    <T> T query(String statement, Object args);
}
