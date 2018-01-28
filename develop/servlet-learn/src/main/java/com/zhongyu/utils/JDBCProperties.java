package com.zhongyu.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ZhongYu on 3/13/2017.
 */
public class JDBCProperties {

    private static Properties properties;

    private static synchronized void loadProperties() {
        if (null == properties) {
            try {
                properties = new Properties();
                InputStream inputStream = JDBCProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
                properties.load(inputStream);
            } catch (Exception e) {
                throw new RuntimeException("未找到JDBC配置文件.");
            }
        }
    }

    public static int getInt(String key) {
        loadProperties();
        return Integer.valueOf(properties.getProperty(key));
    }

    public static String getString(String key) {
        loadProperties();
        return properties.getProperty(key);
    }

    public static double getDouble(String key) {
        loadProperties();
        return Double.valueOf(properties.getProperty(key));
    }

    public static long getLong(String key) {
        loadProperties();
        return Long.valueOf(properties.getProperty(key));
    }

}
