package com.zhongyu.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by ZhongYu on 3/28/2017.
 */
public class C3P0SourceTest {

    @Test
    public void getConnection() throws Exception {
        Connection connection = C3P0Source.getConnection();
        String sql = "select id, name, age, sex, birthday from example";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            System.out.println(result.getInt(1));
            System.out.println(result.getString(2));
        }
    }

}