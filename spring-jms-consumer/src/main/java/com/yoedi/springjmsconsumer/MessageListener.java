package com.yoedi.springjmsconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
@EnableJms
public class MessageListener {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @JmsListener(destination = "MESSAGE_QUEUE_2")
    public void getMessage(final Message jsonMessage) throws JMSException {
        String response = null;

        if(jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)jsonMessage;
            response = textMessage.getText();
        }

        logger.info("Message received : "+response);
//        return response;
    }

}
