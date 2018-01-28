package com.zhongyu.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ZhongYu on 3/28/2017.
 */
public class DruidSource {

    private static com.alibaba.druid.pool.DruidDataSource dataSource;

    static {
        dataSource = new com.alibaba.druid.pool.DruidDataSource();
        dataSource.setDriverClassName(JDBCProperties.getString("jdbc_driver"));
        dataSource.setUrl(JDBCProperties.getString("jdbc_url"));
        dataSource.setUsername(JDBCProperties.getString("jdbc_user"));
        dataSource.setPassword("123456");
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
    }

    public DruidSource() {

    }

    public static synchronized Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
