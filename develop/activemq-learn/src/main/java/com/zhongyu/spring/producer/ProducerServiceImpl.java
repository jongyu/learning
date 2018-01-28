package com.zhongyu.spring.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * Created by ZhongYu on 03/09/2017.
 */
public class ProducerServiceImpl implements ProducerService {

    private Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    //topicDestination,queueDestination
    @Resource(name = "topicDestination")
    private Destination destination;

    @Override
    public void sendMessage(String message) {
        jmsTemplate.send(destination, session -> {
            TextMessage textMessage = session.createTextMessage(message);
            return textMessage;
        });
        logger.info("发送消息" + message);
    }

}
