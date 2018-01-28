package com.zhongyu.spring.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhongYu on 03/09/2017.
 */
public class AppContainer {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("consumer.xml");
    }

}
