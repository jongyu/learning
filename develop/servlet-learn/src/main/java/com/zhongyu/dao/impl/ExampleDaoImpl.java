package com.zhongyu.dao.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.dao.ExampleDao;
import com.zhongyu.utils.DBCPSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by ZhongYu on 3/29/2017.
 */
public class ExampleDaoImpl implements ExampleDao {

    private Connection connection;

    private PreparedStatement statement;

    public ExampleDaoImpl() {
        connection = DBCPSource.getConnection();
    }

    @Override
    public boolean insert(Example example) {
        String sql = "insert into example (name, age, sex, birthday) values (?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, example.getName());
            statement.setInt(2, example.getAge());
            statement.setString(3, example.getSex());
            statement.setObject(4, example.getBirthday());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
