package com.yoedi.springjmsproducer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.*;

/*
 * Manual configuration to connect to activemq server
 */
@RestController
public class SendMessageController {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queueName = "MESSAGE_QUEUE";
    private static Connection connection = null;

    @PostConstruct
    public void init() throws JMSException {
        if (connection == null) {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connection = connectionFactory.createConnection();
            connection.start();
        }
    }

    @PreDestroy
    public void destroy() throws JMSException {
        connection.close();
    }

    @GetMapping("/send")
    public String sendMessage() throws JMSException {
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(queueName);

        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("Hello World");

        producer.send(message);

        return "Send message success";
    }
}
