package com.zy.mybatis.v1;

import java.util.ResourceBundle;


/**
 * 数据库配置信息解析类
 */
public class DataSourceProperties {


    private static final ResourceBundle dataSourceBinding;
    public static final ResourceBundle sqlSourceBinding;

    static {
        /**
         * 数据库配置解析
         */
        dataSourceBinding = ResourceBundle.getBundle("datasource");
        /**
         * sql文件配置解析
         */
        sqlSourceBinding = ResourceBundle.getBundle("sql");
    }

    private static final String url = dataSourceBinding.getString("jdbc.url");
    private static final String username = dataSourceBinding.getString("jdbc.username");
    private static final String password = dataSourceBinding.getString("jdbc.password");
    private static final String driverClassName = dataSourceBinding.getString("jdbc.driver-class-name");
    /**
     * 插件对象相对路径获取，包名+类名
     */
    private static final String pluginPath = dataSourceBinding.getString("mybatis.plugin");

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getPluginPath() {
        return pluginPath;
    }
}
