# Mybatis-ZY
手写mybatis框架
@Author zhangyun
V1版：
1.本项目为理解mybatis核心原理后，手写的精简版

2.项目仅使用了原生jar包：
            <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.21</version>
            </dependency>
3.项目测试类为：com.zy.mybatis.v1.mybatisMain

4.项目的主类及职责：
  4.1 com.zy.mybatis.v1.Configuration类：
      全局配置类
  4.2 com.zy.mybatis.v1.Executor类：
      执行器类
  4.3 com.zy.mybatis.v1.MapperProxy类：
      代理对象
  4.4 com.zy.mybatis.v1.ZYSqlSession类：
      封装用户层查询方法/mapper接口的代理对象获取
  4.5 com.zy.mybatis.v1.DataSourceProperties类：
      数据库配置信息解析类

5.对外暴露的API为ZYSqlSession类.用户层

后续会继续更新V2版本或者完善一些
