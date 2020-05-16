package com.zy.mybatis.v1;


import com.zy.mybatis.v1.Executor.Executor;

public class ZYSqlSession {

    private Configuration configuration;
    private Executor simpleExecutor;

    public ZYSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.simpleExecutor = configuration.newExecutor();
    }

    /**
     * sqlSession的查询方法
     *
     * @param statementId
     * @param param
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId, Object param) {

        String sql = configuration.getSql(statementId);

        return (T) simpleExecutor.query(sql, param);

    }

    public <T> T getMapper(Class clazz) {
        return configuration.getMapper(clazz, this);
    }
}
