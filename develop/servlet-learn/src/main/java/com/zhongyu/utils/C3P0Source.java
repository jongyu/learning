package com.zhongyu.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ZhongYu on 3/28/2017.
 */
public class C3P0Source {

    private static ComboPooledDataSource dataSource = null;

    static {
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(JDBCProperties.getString("jdbc_driver"));
            dataSource.setJdbcUrl(JDBCProperties.getString("jdbc_url"));
            dataSource.setUser(JDBCProperties.getString("jdbc_user"));
            dataSource.setPassword(JDBCProperties.getString("jdbc_password"));
            dataSource.setMinPoolSize(1);
            dataSource.setMaxPoolSize(20);
            dataSource.setInitialPoolSize(4);
            dataSource.setAcquireIncrement(3);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public C3P0Source() {

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
