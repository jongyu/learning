package com.zhongyu.example;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Created by ZhongYu on 10/08/2017.
 */
public class Example {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment environment = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> dataSource = environment.readTextFile("/Users/zhongyu/Personal/Test.txt");
        System.out.println("文件中共有：" + dataSource.count() + " 行");
    }
}
