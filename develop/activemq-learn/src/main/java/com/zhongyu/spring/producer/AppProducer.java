package com.zhongyu.spring.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.TextMessage;

/**
 * Created by ZhongYu on 03/09/2017.
 */
public class AppProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for (int i = 1; i <= 100; i++) {
            service.sendMessage(String.valueOf(i));
        }
        context.close();
    }

}
