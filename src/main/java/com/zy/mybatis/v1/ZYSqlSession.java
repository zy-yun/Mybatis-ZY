package com.zy.mybatis.v1;


public class ZYSqlSession {

    private Configuration configuration;
    private Executor executor;

    public ZYSqlSession(Configuration configuration,Executor executor){
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * sqlSession的查询方法
     * @param statementId
     * @param param
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId,Object param){

        String sql = configuration.getSql(statementId);

       return (T) executor.query(sql,param);

    }

    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }
}
