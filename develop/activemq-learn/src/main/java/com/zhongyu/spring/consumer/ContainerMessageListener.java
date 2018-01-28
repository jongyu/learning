package com.zhongyu.spring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by ZhongYu on 03/09/2017.
 */
public class ContainerMessageListener implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(ContainerMessageListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            logger.info("接收消息" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
