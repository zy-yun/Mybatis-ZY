package com.zy.mybatis.v1;

import com.zy.mybatis.v1.domain.Blog;
import com.zy.mybatis.v1.mapper.BlogMapper;

public class mybatisMain {

    public static void main(String[] args) {
        ZYSqlSession sqlSession = new ZYSqlSession(new Configuration(new DataSourceProperties()),new Executor(new DataSourceProperties()));
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.getBlog(1);
        System.out.println(blog.toString());
    }
}
