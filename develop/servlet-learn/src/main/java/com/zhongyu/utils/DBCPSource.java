package com.zhongyu.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ZhongYu on 3/28/2017.
 */
public class DBCPSource {

    private static BasicDataSource dataSource = null;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(JDBCProperties.getString("jdbc_driver"));
        dataSource.setUrl(JDBCProperties.getString("jdbc_url"));
        dataSource.setUsername(JDBCProperties.getString("jdbc_user"));
        dataSource.setPassword(JDBCProperties.getString("jdbc_password"));
        dataSource.setMaxTotal(20);
        dataSource.setInitialSize(4);
    }

    public DBCPSource() {

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
